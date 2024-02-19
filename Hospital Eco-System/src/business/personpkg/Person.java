/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.personpkg;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author tejageetla
 */
public class Person {

    private String firstName;
    private String name;
    private String lastName;
    private Date dob;
    private String address1;
    private String phoneNumber;
    private String personId;
    private boolean Volunteer;
    private boolean Patient;
    private String emailId;
    private String occupation;
    private String address2;
    private String town;
    private String zipCode;
    private String gender;
    private static int count = 00001;
    private String country;
    private String state;
    private int age;

   
    private List<Insurance> insuranceList;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
        StringBuffer sb = new StringBuffer();
        sb.append("PER");
        sb.append(count);
        personId = sb.toString();
        count++;
        
        insuranceList = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = this.firstName + " " + this.lastName;
    }

    public String getPersonId() {
        return personId;
    }

    public boolean isVolunteer() {
        return Volunteer;
    }

    public void setVolunteer(boolean Volunteer) {
        this.Volunteer = Volunteer;
    }

    public boolean isPatient() {
        return Patient;
    }

    public void setPatient(boolean Patient) {
        this.Patient = Patient;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    
    public List<Insurance> getInsuranceList() {
        return insuranceList;
    }

}
