/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.mirebalaismetadata;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.GlobalProperty;
import org.openmrs.api.context.Context;
import org.openmrs.module.BaseModuleActivator;
import org.openmrs.module.Module;
import org.openmrs.module.ModuleActivator;
import org.openmrs.module.ModuleFactory;
import org.openmrs.module.addresshierarchy.AddressField;
import org.openmrs.module.addresshierarchy.AddressHierarchyLevel;
import org.openmrs.module.addresshierarchy.service.AddressHierarchyService;
import org.openmrs.module.addresshierarchy.util.AddressHierarchyImportUtil;
import org.openmrs.module.emrapi.utils.MetadataUtil;
import org.openmrs.module.metadatasharing.MetadataSharing;
import org.openmrs.module.metadatasharing.resolver.Resolver;
import org.openmrs.module.metadatasharing.resolver.impl.ObjectByNameResolver;
import org.openmrs.module.metadatasharing.resolver.impl.ObjectByUuidResolver;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the logic that is run every time this module is either started or stopped.
 */
public class MirebalaisMetadataActivator extends BaseModuleActivator {

    protected Log log = LogFactory.getLog(getClass());

    private final String ADDRESS_HIERARCHY_CSV_FILE = "org/openmrs/module/mirebalaismetadata/addresshierarchy/haiti_address_hierarchy_entries";

    private final Integer ADDRESS_HIERARCHY_VERSION = 5;

    private MirebalaisMetadataProperties mirebalaisMetadataProperties;

    public MirebalaisMetadataActivator() {
        mirebalaisMetadataProperties = Context.getRegisteredComponents(MirebalaisMetadataProperties.class).get(0);
    }

    /**
     * For unit tests
     *
     * @param mirebalaisMetadataProperties
     */
    public MirebalaisMetadataActivator(MirebalaisMetadataProperties mirebalaisMetadataProperties) {
        this.mirebalaisMetadataProperties = mirebalaisMetadataProperties;
    }

    /**
     * @see ModuleActivator#contextRefreshed()
     */
    public void contextRefreshed() {
        // Since we do all MDS import programmatically, in mirror or parent-child mode, we don't want items being matched
        // except for in specific ways.
        // see https://tickets.openmrs.org/browse/META-323
        List<Resolver<?>> supportedResolvers = new ArrayList<Resolver<?>>();
        supportedResolvers.add(new ObjectByUuidResolver());
        supportedResolvers.add(new ObjectByNameResolver());
        MetadataSharing.getInstance().getResolverEngine().setResolvers(supportedResolvers);

        log.info("Mirebalais Metadata module refreshed");
    }

    /**
     * @see ModuleActivator#started()
     */
    public void started() {
        try {
            installMetadataPackages();
            setupAddressHierarchy();
        } catch (Exception e) {
            Module mod = ModuleFactory.getModuleById("mirebalaismetadata");
            ModuleFactory.stopModule(mod);
            throw new RuntimeException("Failed to start the mirebalaismetadata module", e);
        }
        log.info("Mirebalais Metadata module started");
    }

    private void installMetadataPackages() throws Exception {
        MetadataUtil.setupStandardMetadata(getClass().getClassLoader());
        Context.flushSession();
    }

    private void setupAddressHierarchy() {
        AddressHierarchyService ahService = Context.getService(AddressHierarchyService.class);

        // first check to see if we need to configure the address hierarchy levels
        int numberOfLevels = ahService.getAddressHierarchyLevelsCount();

        // if not 0 or 6 levels, we are in a weird state we can't recover from
        if (numberOfLevels != 0 && numberOfLevels != 6) {
            throw new RuntimeException("Unable to configure address hierarchy as it is currently misconfigured with "
                    + numberOfLevels + "levels");
        }

        // add the address hierarchy levels & entries if they don't exist, otherwise verify that they are correct
        if (numberOfLevels == 0) {
            AddressHierarchyLevel country = new AddressHierarchyLevel();
            country.setAddressField(AddressField.COUNTRY);
            ahService.saveAddressHierarchyLevel(country);

            AddressHierarchyLevel stateProvince = new AddressHierarchyLevel();
            stateProvince.setAddressField(AddressField.STATE_PROVINCE);
            stateProvince.setParent(country);
            ahService.saveAddressHierarchyLevel(stateProvince);

            AddressHierarchyLevel cityVillage = new AddressHierarchyLevel();
            cityVillage.setAddressField(AddressField.CITY_VILLAGE);
            cityVillage.setParent(stateProvince);
            ahService.saveAddressHierarchyLevel(cityVillage);

            AddressHierarchyLevel address3 = new AddressHierarchyLevel();
            address3.setAddressField(AddressField.ADDRESS_3);
            address3.setParent(cityVillage);
            ahService.saveAddressHierarchyLevel(address3);

            AddressHierarchyLevel address1 = new AddressHierarchyLevel();
            address1.setAddressField(AddressField.ADDRESS_1);
            address1.setParent(address3);
            ahService.saveAddressHierarchyLevel(address1);

            AddressHierarchyLevel address2 = new AddressHierarchyLevel();
            address2.setAddressField(AddressField.ADDRESS_2);
            address2.setParent(address1);
            ahService.saveAddressHierarchyLevel(address2);
        }
        // at least verify that the right levels exist
        // TODO: perhaps do more validation here?
        else {
            AddressField[] fields = {AddressField.COUNTRY, AddressField.STATE_PROVINCE, AddressField.CITY_VILLAGE,
                    AddressField.ADDRESS_3, AddressField.ADDRESS_1, AddressField.ADDRESS_2};
            int i = 0;

            for (AddressHierarchyLevel level : ahService.getOrderedAddressHierarchyLevels(true)) {
                if (level.getAddressField() != fields[i]) {
                    throw new RuntimeException("Address field " + i + " improperly configured: is "
                            + level.getAddressField() + " but should be " + fields[i]);
                }
                i++;
            }
        }

        // load in the csv file if necessary
        int installedAddressHierarchyVersion = mirebalaisMetadataProperties.getInstalledAddressHierarchyVersion();

        if (installedAddressHierarchyVersion < ADDRESS_HIERARCHY_VERSION) {
            // delete any existing entries
            Context.getService(AddressHierarchyService.class).deleteAllAddressHierarchyEntries();

            // import the new file
            InputStream file = getClass().getClassLoader().getResourceAsStream(ADDRESS_HIERARCHY_CSV_FILE + "_"
                    + ADDRESS_HIERARCHY_VERSION + ".csv");
            AddressHierarchyImportUtil.importAddressHierarchyFile(file, "\\|", "\\^");

            // update the installed version
            GlobalProperty installedAddressHierarchyVersionObject = Context.getAdministrationService()
                    .getGlobalPropertyObject(MirebalaisMetadataProperties.GP_INSTALLED_ADDRESS_HIERARCHY_VERSION);
            if (installedAddressHierarchyVersionObject == null) {
                installedAddressHierarchyVersionObject = new GlobalProperty();
                installedAddressHierarchyVersionObject.setProperty(MirebalaisMetadataProperties.GP_INSTALLED_ADDRESS_HIERARCHY_VERSION);
            }
            installedAddressHierarchyVersionObject.setPropertyValue(ADDRESS_HIERARCHY_VERSION.toString());
            Context.getAdministrationService().saveGlobalProperty(installedAddressHierarchyVersionObject);
        }


    }
}
