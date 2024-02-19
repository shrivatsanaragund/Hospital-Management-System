package business;

import business.common.NeedHelp;
import business.enterprisepkg.Enterprise;
import business.Network.Network;
import business.organizationpkg.Organization;
import business.personpkg.Insurance;
import business.personpkg.Person;
import business.personpkg.Scheme;
import business.personpkg.Tablet;
import business.rolepkg.AdminRole;
import business.rolepkg.DepartmentsAdminRole;
import business.rolepkg.InsuranceAdminRole;
import business.rolepkg.DoctorRole;
import business.rolepkg.GovtSecRole;
import business.rolepkg.PatientRole;
import business.rolepkg.PharmacyAdminRole;
import business.rolepkg.SystemAdminRole;
import business.userAccountpkg.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {

//    public static EcoSystem configure(){
//        
//        
//        
//        //Create a network
//        //create an enterprise
//        //initialize some organizations
//        //have some employees 
//        //create user account
//  
//        EcoSystem ecoSystem = populateEnterpriseData();
//        return ecoSystem;
//    }
    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();

        Person person = system.getPersonDirectory().addPerson();
        person.setFirstName("Sys");
        person.setLastName("Admin");
        person.setName();

        UserAccount ua = system.getUserAccountDirectory().addUserAccount("sysadmin", "sysadmin", person, new SystemAdminRole());
        ua.setEnabled(true);

//        NeedHelp needHelp = system.addNeedHelp();
//        needHelp.setHelp("Snow Shovel");
//        needHelp.setHelp("Grass Cutting");
//        needHelp.setHelp("Gardening");
//        needHelp.setHelp("Grocery Shopping");
//Adding Network
        Network network = system.addNetwork();
        network.setCountry("United States");
        network.setState("Massachusetts");
        network.setCity("Boston");

        Network network1 = system.addNetwork();
        network1.setCountry("United States");
        network1.setState("Massachusetts");
        network1.setCity("Bolyston");
        Network network2 = system.addNetwork();
        network2.setCountry("India");
        network2.setState("Karnataka");
        network2.setCity("Bengaluru");

        // Hospital
        Enterprise enterprise = network.getEnterpriseDirectory().addEnterprise("Tufts Medical Center", Enterprise.EnterpriseType.Hospital);
        //enterprise = network.getEnterpriseDirectory().addEnterprise("BostonHeartHelp", Enterprise.EnterpriseType.Insurance);
//        person = enterprise.getPersonDirectory().addPerson();
//        person.setLastName("Hospital");
//        person.setName();

        //Admin username and password
        UserAccount account = enterprise.getUserAccountDirectory().addUserAccount("admin", "admin", person, new AdminRole());
        account.setEnabled(true);
        account.setNetwork(network);

        //enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Departments);
        //Organization organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Pharmacy);
        //person = organization.getPersonDirectory().addPerson();    
        // person.setFirstName("Radiology");
        // person.setLastName("Medical Store");
        // person.setName();
        // enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Patient);
        Organization organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Patient);
        Person person2 = organization.getPersonDirectory().addPerson();
        person2.setFirstName("Patient1");
        person2.setLastName("Mpatient");
        person2.setName();
        person2.setAge(78);

        Organization organization1 = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Doctor);
      Person  person3 = organization1.getPersonDirectory().addPerson();
        person3.setFirstName("John");
        person3.setLastName("Deo");
        person3.setAge(78);
        person3.setAddress1("360 Huntington Avenue");
        person3.setGender("Male");
        person3.setCountry("United States");
        person3.setState("Massachussets");
        person3.setTown("Boston");
        person3.setZipCode("02115");
        person3.setPhoneNumber("3512308556");
        person3.setEmailId("doctor_One@gmail.com");

        person3.setName();

        Tablet tab = system.getPersonDirectory().newTablet("Paracetamol", "Param", "650MG", 10);

        Insurance insurance01 = system.getPersonDirectory().newBInsurance("Health Insurance - Basic Plan", "25000$", "$250 per month", "Up $25000 claim");
        Insurance insurance02 = system.getPersonDirectory().newSInsurance("Health Insurance - Standard Plan", "25000$", "$250 per month", "Up $125000 claim");
        Insurance insurance03 = system.getPersonDirectory().newSInsurance("Health Insurance - Standard Plan", "25000$", "$2500 per month", "Up $225000 claim");
        Insurance insurance04 = system.getPersonDirectory().newSInsurance("Health Insurance - Standard Plan", "25000$", "$2500 per month", "Up $215000 claim");
        Insurance insurance05 = system.getPersonDirectory().newPInsurance("Health Insurance - Premium Plan", "25000$", "$9000 per month", "Up $445000 claim");
        Insurance insurance06 = system.getPersonDirectory().newBInsurance("Health Insurance - Basic Plan", "25000$", "$250 per month", "Up $25000 claim");
        Insurance insurance07 = system.getPersonDirectory().newBInsurance("Health Insurance - Basic Plan", "25000$", "$250 per month", "Up $25000 claim");

        
           // SchemesDirectory schemeDirectory = business.getSchemedirectory();
        Scheme sch01 = system.getPersonDirectory().newScheme("402", "Affordable Care Act (ACA)", "Open to U.S. citizens and legal residents", "Cost reduction 30%");
        Scheme sch02 = system.getPersonDirectory().newScheme("1033", "Medicaid Expansion", "low-income adults in the federal poverty level (FPL)", "100% refund");
        Scheme sch03 = system.getPersonDirectory().newScheme("1789", "Medicaid", "Open to Female U.S. citizens and legal residents", "100% refund");
        Scheme sch04 = system.getPersonDirectory().newScheme("4232", "Children's Health Insurance Program (CHIP)", "Provides coverage for children in families with low incomes", "60%% refund, Full refund if under privileged");
        Scheme sch05 = system.getPersonDirectory().newScheme("4182", "Veterans Health Administration (VHA)", "Eligibility is generally based on military service, discharge status, and service-connected disabilities.", "100% refund");

        account = organization1.getUserAccountDirectory().addUserAccount("doctor", "doctor", person, new DoctorRole());
        account.setNetwork(network);
        account.setEnabled(true);
//        account = enterprise.getUserAccountDirectory().addUserAccount("labrole", "labrole", person, new LabAdminRole());
//        account.setEnabled(true);
//        account.setNetwork(network);
        account = organization.getUserAccountDirectory().addUserAccount("patient", "patient", person, new PatientRole());
        account.setEnabled(true);
        account.setNetwork(network);
//        
//        enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Lab);
//        organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Blood);
//        person = organization.getPersonDirectory().addPerson();
//
//        person.setFirstName("Laboratory");
//        person.setLastName("Blood Bank");
//        person.setName();
//
//        account = organization.getUserAccountDirectory().addUserAccount("bsup", "bsup", person, new BloodAdminRole());
//        account.setNetwork(network);
//        account.setEnabled(true);
//
////        // Manager
////        person = organization.getPersonDirectory().addPerson();
////
////        person.setFirstName("Manager");
////        person.setLastName("Boston");
////        person.setName();
////
////        account = organization.getUserAccountDirectory().addUserAccount("bman", "bman", person, new HeartHelpManagerRole());
////        account.setNetwork(network);
////        account.setEnabled(true);
//
//        // Non Profit
        Enterprise enterprise2 = network.getEnterpriseDirectory().addEnterprise("Global Insurance Provide", Enterprise.EnterpriseType.Insurance);
        Organization organization3 = enterprise2.getOrganizationDirectory().addOrganization(Organization.Type.Insurance);
        //Organization organization4 = enterprise2.getOrganizationDirectory().addOrganization(Organization.Type.PersonalInsurance);

        person = enterprise2.getPersonDirectory().addPerson();
        person.setLastName("Insurance Manager");
        person.setName();
        account = enterprise2.getUserAccountDirectory().addUserAccount("CI", "CI", person, new InsuranceAdminRole());
        account.setEnabled(true);
        account.setNetwork(network);
//        organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Donor);
//        person = organization.getPersonDirectory().addPerson();
//
//        person.setFirstName("Donor");
//        person.setLastName("Boston");
//        person.setName();
//
//        account = organization.getUserAccountDirectory().addUserAccount("bdon", "bdon", person, new DonorAdminRole());
//        account.setNetwork(network);
//        account.setEnabled(true);

        // Insurance
        enterprise = network.getEnterpriseDirectory().addEnterprise("Insurance", Enterprise.EnterpriseType.Insurance);
        person = enterprise.getPersonDirectory().addPerson();
//        person.setLastName("Insurance Company");
        person.setName();
        account = enterprise.getUserAccountDirectory().addUserAccount("ins", "ins", person, new InsuranceAdminRole());
        account.setEnabled(true);
        account.setNetwork(network);
//        organization = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.CorporateInsurance);
//        person = organization.getPersonDirectory().addPerson();
//
//        person.setFirstName("Corporate");
//        person.setLastName("Insurance");
//        person.setName();
//
////        account = organization.getUserAccountDirectory().addUserAccount("bdoc", "bdoc", person, new DoctorRole());
////        account.setNetwork(network);
////        account.setEnabled(true);
//
//        // Govt
        Enterprise enterprise3 = network.getEnterpriseDirectory().addEnterprise("Govt", Enterprise.EnterpriseType.Government);
        person = enterprise.getPersonDirectory().addPerson();
        person.setLastName("Govt Admin Admin");
        person.setName();
        account = enterprise.getUserAccountDirectory().addUserAccount("bgt", "bgt", person, new GovtSecRole());
        account.setEnabled(true);
        account.setNetwork(network);
        Organization organization5 = enterprise.getOrganizationDirectory().addOrganization(Organization.Type.Schemes);
        person = organization.getPersonDirectory().addPerson();
        person.setFirstName("Government");
        person.setLastName("Schemes");
        person.setName();
        
        UserAccount account9 = enterprise.getUserAccountDirectory().addUserAccount("dt", "dt", person, new DepartmentsAdminRole());
        account.setEnabled(true);
        account.setNetwork(network);

//        account = organization.getUserAccountDirectory().addUserAccount("scheme", "scheme", person, new SchemesAdminRole());
//        account.setNetwork(network);
//        account.setEnabled(true);

        return system;
    }

}
