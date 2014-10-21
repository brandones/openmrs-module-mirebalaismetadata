package org.openmrs.module.mirebalaismetadata.deploy.bundle;

import org.openmrs.Location;
import org.openmrs.LocationAttribute;
import org.openmrs.module.coreapps.CoreAppsConstants;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.location;
import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.locationAttribute;

@Component
public class MirebalaisSpecificMetadata extends MirebalaisMetadataBundle {

    public static final class LocationAttributeTypes {
        public static final String LOCATION_CODE = "64f01c78-191d-4947-a201-7e0a7f0caf21";
    }

    public static final class MirebalaisHospitalLocations {
        public static final String MIREBALAIS_HOSPITAL = "a084f714-a536-473b-94e6-ec317b152b43";

        public static final String LACOLLINE = "23e7bb0d-51f9-4d5f-b34b-2fbbfeea1960";

        public static final String CLINIC_REGISTRATION = "787a2422-a7a2-400e-bdbb-5c54b2691af5";
        public static final String EMERGENCY_DEPARTMENT_RECEPTION = "afa09010-43b6-4f19-89e0-58d09941bcbd";
        public static final String CENTRAL_ARCHIVES = "be50d584-26b2-4371-8768-2b9565742b3b";

        public static final String OUTPATIENT_CLINIC = "199e7d87-92a0-4398-a0f8-11d012178164";
        public static final String EMERGENCY = "f3a5586e-f06c-4dfb-96b0-6f3451a35e90";
        public static final String COMMUNITY_HEALTH = "dce85b2e-6946-4798-9037-d00f123df7bd";
        public static final String DENTAL = "4f2d9af1-7eec-4228-bbd6-7b0774c6c267";

        public static final String WOMENS_CLINIC = "9b2066a2-7087-47f6-9b3a-b001037432a3";
        public static final String WOMENS_TRIAGE = "d65eb8cf-d781-4ea8-9d9a-2b3e03c6074c";
        public static final String LABOR_AND_DELIVERY = "dcfefcb7-163b-47e5-84ae-f715cf3e0e92";
        public static final String ANTEPARTUM_WARD = "272bd989-a8ee-4a16-b5aa-55bad4e84f5c";
        public static final String POSTPARTUM_WARD = "950852f3-8a96-4d82-a5f8-a68a92043164";
        public static final String POST_OP_GYN = "ec9d2302-b525-45ce-bebe-42ea1d38b251";

        public static final String SURGICAL_WARD = "7d6cc39d-a600-496f-a320-fd4985f07f0b";
        public static final String OPERATING_ROOMS = "41736d90-12f9-4c16-b5a1-5af170b7bf2a";
        public static final String PRE_OP_PACU = "109a13a9-029d-498d-b66e-bab5eb396996";

        public static final String MAIN_LABORATORY = "53cd4959-5f4d-4ddc-9971-7fc27e0b7946";
        public static final String WOMENS_OUTPATIENT_LABORATORY = "0198d2c3-9c08-45b6-88df-cbb60446ef00";
        public static final String RADIOLOGY = "cfe92278-0181-4315-ab7d-1731753120f0";

        public static final String MENS_INTERNAL_MEDICINE = "e5db0599-89e8-44fa-bfa2-07e47d63546f";
        public static final String MENS_INTERNAL_MEDICINE_A = "3b6f010b-5d44-4ded-85b3-70ea7ba79fd5";
        public static final String MENS_INTERNAL_MEDICINE_B = "a296d225-0312-4ce5-836c-cb2d8e952f47";
        public static final String WOMENS_INTERNAL_MEDICINE = "2c93919d-7fc6-406d-a057-c0b640104790";
        public static final String WOMENS_INTERNAL_MEDICINE_A = "8e4e930b-e801-44c5-8895-e7ef6feb6d73";
        public static final String WOMENS_INTERNAL_MEDICINE_B = "195d0af1-3887-4a28-a542-b832099fe3ee";
        public static final String PEDIATRICS = "c9ab4c5c-0a8a-4375-b986-f23c163b2f69";
        public static final String PEDIATRICS_A = "e4ae2d28-d57c-42ba-b7aa-f6fcac421b2c";
        public static final String PEDIATRICS_B = "e752ec51-5633-489f-aef1-01f285c03f38";

        public static final String ICU = "b6fcd85f-5995-43c9-875f-3bb2299087ff";
        public static final String NICU = "62a9500e-a1a5-4235-844f-3a8cc0765d53";
        public static final String ISOLATION = "29437276-aeae-4ea8-8219-720886cdc87f";
        public static final String CHEMOTHERAPY = "dc8413be-1075-48b5-9857-9bd4954686ed";
        public static final String OUTPATIENT_CLINIC_PHARMACY = "79892ece-79f1-4674-abb5-a52c1898c762";
        public static final String WOMENS_AND_CHILDRENS_PHARMACY = "de8892ff-e755-4ef0-ae0a-c27d2c1e6a74";
        public static final String REHABILITATION = "5fd9a9b6-a9af-47be-b5d8-f2d4239dfdc1";
        public static final String FAMILY_PLANNING_LOCAITON = "09af1ef5-d664-4c1f-a9e3-9c8d69bd77c4";
        public static final String BLOOD_BANK = "4ed8c0d3-8aed-4f80-96e8-55648abf51af";

    }

    public static final class RetiredMirebalaisLocations {

        public static final String ED_OBSERVATION = "459c97ba-8d90-485d-8993-9540c55166f6";
        public static final String ED_BOARDING = "8355ad15-c3c9-4471-a1e7-dc18b7983087";

    }

    @Override
    public void install() throws Exception {

        // Locations
        log.info("Installing Mirebalais Locations");

        install(location("Hôpital Universitaire de Mirebalais","Mirebalais (MoH code 62101)",
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                null,
                Arrays.asList(CoreMetadata.LocationTags.MEDICAL_RECORD_LOCATION,
                        CoreMetadata.LocationTags.VISIT_LOCATION)));

        install(location("Lacolline","Lacolline", MirebalaisHospitalLocations.LACOLLINE));

        install(location("Achiv Santral","Central Archives room at Mirebalais Hospital",
                MirebalaisHospitalLocations.CENTRAL_ARCHIVES,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.LOGIN_LOCATION)));

        install(location("Bank Pou San","Blood Bank at Mirebalais Hospital",
                MirebalaisHospitalLocations.BLOOD_BANK,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.LOGIN_LOCATION)));

        install(location("Biwo Resepsyon","Clinic Registration at Mirebalais Hospital",
                MirebalaisHospitalLocations.CLINIC_REGISTRATION,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.LOGIN_LOCATION)));

        install(location("Chimyoterapi","Chemotherapy at Mirebalais Hospital",
                MirebalaisHospitalLocations.CHEMOTHERAPY,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.APPOINTMENT_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION)));

        install(location("Dantis","Dental clinic at Mirebalais Hospital (Dental Clinic).",
                MirebalaisHospitalLocations.DENTAL,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.APPOINTMENT_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Ijans","Emergency room at Mirebalais Hospital (Ijans)",
                MirebalaisHospitalLocations.EMERGENCY,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.ED_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Ijans Resepsyon","Emergency registration and check-in",
                MirebalaisHospitalLocations.EMERGENCY_DEPARTMENT_RECEPTION,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.LOGIN_LOCATION)));

        install(location("Ijans | Sante Fanm","Women’s Triage at Mirebalais Hospital",
                MirebalaisHospitalLocations.WOMENS_TRIAGE,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Klinik Ekstèn","The outpatient clinic at Mirebalais Hospital (Klinik Extern).",
                MirebalaisHospitalLocations.OUTPATIENT_CLINIC,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.APPOINTMENT_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Klinik Exten Famasi","Outpatient Clinic Pharmacy at Mirebalais Hospital. For adults. Women with general medical conditions are also seen here.",
                MirebalaisHospitalLocations.OUTPATIENT_CLINIC_PHARMACY,
                MirebalaisHospitalLocations.OUTPATIENT_CLINIC,
                Arrays.asList(CoreMetadata.LocationTags.APPOINTMENT_LOCATION,
                        CoreMetadata.LocationTags.DISPENSING_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION)));

        install(location("Laboratwa Ekstèn pou Fanm","Women’s Outpatient Laboratory at Mirebalais Hospital",
                MirebalaisHospitalLocations.WOMENS_OUTPATIENT_LABORATORY,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.APPOINTMENT_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION)));

        install(location("Laboratwa Prensipal","Main laboratory at Mirebalais Hospital",
                MirebalaisHospitalLocations.MAIN_LABORATORY,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.APPOINTMENT_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION)));

        install(location("Planin Familyal","Family Planning Clinic",
                MirebalaisHospitalLocations.FAMILY_PLANNING_LOCAITON,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.APPOINTMENT_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION)));

        install(location("Radyografi","Radiology at Mirebalais Hospital",
                MirebalaisHospitalLocations.RADIOLOGY,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.APPOINTMENT_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION)));

        install(location("Sal Aprè Akouchman","Postpartum ward at Mirebalais Hospital (After giving birth)",
                MirebalaisHospitalLocations.POSTPARTUM_WARD,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.ADMISSION_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.SURGERY_NOTE_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Sal Avan Akouchman","Antepartum ward at Mirebalais Hospital (Before giving birth)",
                MirebalaisHospitalLocations.ANTEPARTUM_WARD,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.ADMISSION_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Sal Aprè Operayson", "Surgical Ward at Mirebalais Hospital (Surgery)",
                MirebalaisHospitalLocations.SURGICAL_WARD,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.ADMISSION_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.SURGERY_NOTE_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Sal Aprè Operayson | Sante Fanm", "Post-op GYN at Mirebalais Hospital (Recovery after surgery related to gynecology)",
                MirebalaisHospitalLocations.POST_OP_GYN,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.ADMISSION_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.SURGERY_NOTE_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Sal Avan Operasyon | PACU", "Pre-op/PACU at Mirebalais Hospital (Before surgery, and Post-Anesthesia Care Unit)",
                MirebalaisHospitalLocations.PRE_OP_PACU,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.LOGIN_LOCATION)));

        install(location("Sal Fanm","Women’s Internal Medicine at Mirebalais Hospital (Inpatient ward for women)",
                MirebalaisHospitalLocations.WOMENS_INTERNAL_MEDICINE,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.APPOINTMENT_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Sal Fanm A","Women’s Internal Medicine A at Mirebalais Hospital (1st Inpatient ward for women)",
                MirebalaisHospitalLocations.WOMENS_INTERNAL_MEDICINE_A,
                MirebalaisHospitalLocations.WOMENS_INTERNAL_MEDICINE,
                Arrays.asList(CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION)));

        install(location("Sal Fanm B","Women’s Internal Medicine B at Mirebalais Hospital (2nd Inpatient ward for women)",
                MirebalaisHospitalLocations.WOMENS_INTERNAL_MEDICINE_B,
                MirebalaisHospitalLocations.WOMENS_INTERNAL_MEDICINE,
                Arrays.asList(CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION)));

        install(location("Sal Gason","Men’s Internal Medicine at Mirebalais Hospital (Inpatient ward for men)",
                MirebalaisHospitalLocations.MENS_INTERNAL_MEDICINE,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.ADMISSION_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Sal Gason A","Men’s Internal Medicine A at Mirebalais Hospital (1st Inpatient ward for men)",
                MirebalaisHospitalLocations.MENS_INTERNAL_MEDICINE_A,
                MirebalaisHospitalLocations.MENS_INTERNAL_MEDICINE,
                Arrays.asList(CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION)));

        install(location("Sal Gason B","Men’s Internal Medicine B at Mirebalais Hospital (2nd Inpatient ward for men)",
                MirebalaisHospitalLocations.MENS_INTERNAL_MEDICINE_B,
                MirebalaisHospitalLocations.MENS_INTERNAL_MEDICINE,
                Arrays.asList(CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION)));

        install(location("Sal Izolman","Isolation at Mirebalais Hospital",
                MirebalaisHospitalLocations.ISOLATION,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.ADMISSION_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Sal Operasyon","Operating Rooms at Mirebalais Hospital (all six operating rooms)",
                MirebalaisHospitalLocations.OPERATING_ROOMS,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.SURGERY_NOTE_LOCATION)));

        install(location("Sal Reyabilitasyon","Rehabilitation Ward",
                MirebalaisHospitalLocations.REHABILITATION,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.ADMISSION_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Sal Timoun","Pediatrics at Mirebalais Hospital (Inpatient ward for children)",
                MirebalaisHospitalLocations.PEDIATRICS,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.ADMISSION_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Sal Timoun A","Pediatrics A at Mirebalais Hospital (1st Inpatient ward for children)",
                MirebalaisHospitalLocations.PEDIATRICS_A,
                MirebalaisHospitalLocations.PEDIATRICS,
                Arrays.asList(CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION)));

        install(location("Sal Timoun B","Pediatrics B at Mirebalais Hospital (2nd Inpatient ward for children)",
                MirebalaisHospitalLocations.PEDIATRICS_B,
                MirebalaisHospitalLocations.PEDIATRICS,
                Arrays.asList(CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION)));

        install(location("Sante Fanm","Women's Outpatient clinic at Mirebalais Hospital (Sante Fanm).",
                MirebalaisHospitalLocations.WOMENS_CLINIC,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.ADMISSION_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        // out of order because child of above location ^^
        install(location("Famasi Famn ak Ti moun","Women and Children's Pharmacy at Mirebalais Hospital.",
                MirebalaisHospitalLocations.WOMENS_AND_CHILDRENS_PHARMACY,
                MirebalaisHospitalLocations.WOMENS_CLINIC,
                Arrays.asList(CoreMetadata.LocationTags.APPOINTMENT_LOCATION,
                        CoreMetadata.LocationTags.DISPENSING_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION)));

        install(location("Sante Kominotè","Community Health clinic at Mirebalais Hospital (Community Health clinic).",
                MirebalaisHospitalLocations.COMMUNITY_HEALTH,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.APPOINTMENT_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Swen Entansif","ICU at Mirebalais Hospital (Intensive Care Unit)",
                MirebalaisHospitalLocations.ICU,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.LOGIN_LOCATION)));

        install(location("Swen Entansif Neonatal","NICU at Mirebalais Hospital (Neonatal Intensive Care Unit)",
                MirebalaisHospitalLocations.NICU,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.ADMISSION_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        install(location("Travay e Akouchman","Labor and Delivery at Mirebalais Hospital (Births)",
                MirebalaisHospitalLocations.LABOR_AND_DELIVERY,
                MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                Arrays.asList(CoreMetadata.LocationTags.ADMISSION_LOCATION,
                        CoreMetadata.LocationTags.CONSULT_NOTE_LOCATION,
                        CoreMetadata.LocationTags.LOGIN_LOCATION,
                        CoreMetadata.LocationTags.TRANSFER_LOCAITON)));

        log.info("Retiring old Mirebalais Locations");

        uninstall(possible(Location.class, RetiredMirebalaisLocations.ED_OBSERVATION), "no longer used");
        uninstall(possible(Location.class, RetiredMirebalaisLocations.ED_BOARDING), "no longer used");

        // Location Attributes
        install(locationAttribute(MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL,
                CoreMetadata.LocationAttributeTypes.NAME_TO_PRINT_ON_ID_CARD,
                "Mirebalais",
                "19cddbbe-fe82-448f-b2ab-95c4b73bc6f5"));

        install(locationAttribute(MirebalaisHospitalLocations.CENTRAL_ARCHIVES,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M028",
                "2705ac66-949e-461a-8f73-ea087ea28bb0"));

        install(locationAttribute(MirebalaisHospitalLocations.BLOOD_BANK,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M033",
                "90307894-ec4a-4dad-bb00-d44f633e6e18"));

        install(locationAttribute(MirebalaisHospitalLocations.CLINIC_REGISTRATION,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M029",
                "58b76638-90b2-4e23-b0d9-b63f11c49e79"));

        install(locationAttribute(MirebalaisHospitalLocations.CHEMOTHERAPY,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M038",
                "7df84969-3685-4894-84aa-17b58ad93a94"));

        install(locationAttribute(MirebalaisHospitalLocations.DENTAL,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M019",
                "41fec28b-dd0c-4011-be67-9ebca234ebfd"));

        install(locationAttribute(MirebalaisHospitalLocations.WOMENS_AND_CHILDRENS_PHARMACY,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M032",
                "d3906d5e-6b4e-4c2b-b19a-26e247d89209"));

        install(locationAttribute(MirebalaisHospitalLocations.EMERGENCY,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M004",
                "82c82a3d-5153-4eaf-9ad5-154eeffe0f1b"));

        install(locationAttribute(MirebalaisHospitalLocations.EMERGENCY_DEPARTMENT_RECEPTION,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M034",
                "709ee7f1-5d3d-493d-a931-6fca9a49b7ff"));

        install(locationAttribute(MirebalaisHospitalLocations.WOMENS_TRIAGE,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M027",
                "157c7f05-fa41-4ccb-a6cb-599d8c731aee"));

        install(locationAttribute(MirebalaisHospitalLocations.OUTPATIENT_CLINIC,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M005",
                "350badbe-82a1-42f6-81a3-e2f7aaec5d1e"));

        install(locationAttribute(MirebalaisHospitalLocations.OUTPATIENT_CLINIC_PHARMACY,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M031",
                "96af5ad1-c2c5-4cf4-9333-26f0c1f2e75b"));

        install(locationAttribute(MirebalaisHospitalLocations.WOMENS_OUTPATIENT_LABORATORY,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M024",
                "5d82d626-27a4-42f8-898c-236426810e40"));

        install(locationAttribute(MirebalaisHospitalLocations.MAIN_LABORATORY,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M007",
                "f3d2b863-4524-40a1-8908-6646255e2e32"));

        install(locationAttribute(MirebalaisHospitalLocations.RADIOLOGY,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M010",
                "d8be457b-c418-4581-8673-50ca20d2ba42"));

        install(locationAttribute(MirebalaisHospitalLocations.POSTPARTUM_WARD,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M008",
                "a01858fe-2f18-418d-8b4b-5d3f926efc4f"));

        install(locationAttribute(MirebalaisHospitalLocations.SURGICAL_WARD,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M025",
                "162c86a7-5918-4311-ae98-25708541e97f"));

        install(locationAttribute(MirebalaisHospitalLocations.POST_OP_GYN,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M009",
                "afa2909f-2b68-4923-9c29-07e8d37a99a1"));

        install(locationAttribute(MirebalaisHospitalLocations.ANTEPARTUM_WARD,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M006",
                "57f66e57-ddbf-41dd-b72b-734feb9cfc10"));

        install(locationAttribute(MirebalaisHospitalLocations.PRE_OP_PACU,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M013",
                "01b1db36-bf5b-450e-a53d-a5ac6c50b5b2"));

        install(locationAttribute(MirebalaisHospitalLocations.WOMENS_INTERNAL_MEDICINE,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M035",
                "848120b5-a8ed-453d-b17c-3a1532f87e71"));

        install(locationAttribute(MirebalaisHospitalLocations.WOMENS_INTERNAL_MEDICINE_A,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M026",
                "4c7fe8b5-e965-4cd1-9021-dfa994c16838"));

        install(locationAttribute(MirebalaisHospitalLocations.WOMENS_INTERNAL_MEDICINE_B,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M016",
                "bdae8ec9-3ed0-4b93-a38b-0c61674aae8a"));

        install(locationAttribute(MirebalaisHospitalLocations.MENS_INTERNAL_MEDICINE,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M036",
                "27f73024-9317-4b37-bc79-82ccad31fced"));

        install(locationAttribute(MirebalaisHospitalLocations.MENS_INTERNAL_MEDICINE_A,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M020",
                "3d2220a6-2ed2-4f9d-a856-67f79ae9b1c9"));

        install(locationAttribute(MirebalaisHospitalLocations.MENS_INTERNAL_MEDICINE_B,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M021",
                "ec2b429b-6c73-4863-bd89-a6501d58d540"));

        install(locationAttribute(MirebalaisHospitalLocations.ISOLATION,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M017",
                "1f07a471-cd35-429d-a82b-7bff40650216"));

        install(locationAttribute(MirebalaisHospitalLocations.OPERATING_ROOMS,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M015",
                "d08b49d0-be14-49bb-9319-02f4125834c8"));

        install(locationAttribute(MirebalaisHospitalLocations.REHABILITATION,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M039",
                "0b2d83a4-7c45-417e-a08c-1e46dea54c73"));

        install(locationAttribute(MirebalaisHospitalLocations.PEDIATRICS,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M037",
                "ebaa5b54-7405-4c99-a877-afdb8e199df4"));

        install(locationAttribute(MirebalaisHospitalLocations.PEDIATRICS_A,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M012",
                "d5827677-9adf-48b2-b6fa-e769af037873"));

        install(locationAttribute(MirebalaisHospitalLocations.PEDIATRICS_B,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M022",
                "24f2c381-2aa9-44cf-aeca-165d7d0196e8"));

        install(locationAttribute(MirebalaisHospitalLocations.WOMENS_CLINIC,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M003",
                "703614f6-c941-4ec1-a639-65e308762034"));

        install(locationAttribute(MirebalaisHospitalLocations.COMMUNITY_HEALTH,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M011",
                "0b70293d-0995-404c-924c-e4f54d6860b5"));

        install(locationAttribute(MirebalaisHospitalLocations.ICU,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M018",
                "8b13c4c2-8c44-4faa-b385-2734594 a8d44"));

        install(locationAttribute(MirebalaisHospitalLocations.NICU,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M014", "f8eba8dc-8939-4c5e-a39b-110d833 b86e6"));

        install(locationAttribute(MirebalaisHospitalLocations.LABOR_AND_DELIVERY,
                CoreMetadata.LocationAttributeTypes.LOCATION_CODE,
                "M023", "54750c8b-d979-4d3b-bd1d-57830009e064"));

        log.info("Voiding old location attributes");

        uninstall(possible(LocationAttribute.class, "f170427f-8cc7-421e-bd52-350c3580ea90"), "belongs to retired location");

        // GLOBAL PROPERTIES

        Map<String, String> properties = new LinkedHashMap<String, String>();

        // Core Apps
        properties.put(CoreAppsConstants.GP_DEFAULT_PATIENT_IDENTIFIER_LOCATION, MirebalaisHospitalLocations.MIREBALAIS_HOSPITAL);

        setGlobalProperties(properties);

    }
}