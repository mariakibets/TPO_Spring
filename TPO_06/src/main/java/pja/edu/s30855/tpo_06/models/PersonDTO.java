package pja.edu.s30855.tpo_06.models;

import java.time.LocalDate;

public class PersonDTO {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private String university;
    private String countryOfOrigin;
    private String jobTitle;
    private String phoneNumber;
    private String email;
    private String hobby;
    private String company;

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getFirstName() {return firstName;}

    public String getLastName() {return lastName;}

    public void setEmail(String email) {this.email = email;}

    public String getEmail() {return email;}

    public String getAddress() {return address;}

    public String getCompany() {return company;}

    public String getCountryOfOrigin() {return countryOfOrigin;}

    public LocalDate getDateOfBirth() {return dateOfBirth;}

    public String getHobby() {return hobby;}

    public String getJobTitle() {return jobTitle;}

    public String getPhoneNumber() {return phoneNumber;}

    public String getUniversity() {return university;}

    public void setAddress(String address) {this.address = address;}

    public void setCompany(String company) {this.company = company;}

    public void setCountryOfOrigin(String countryOfOrigin) {this.countryOfOrigin = countryOfOrigin;}

    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public void setHobby(String hobby) {this.hobby = hobby;}

    public void setJobTitle(String jobTitle) {this.jobTitle = jobTitle;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public void setUniversity(String university) {this.university = university;}
}
