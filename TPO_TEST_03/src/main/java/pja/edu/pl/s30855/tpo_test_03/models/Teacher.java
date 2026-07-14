package pja.edu.pl.s30855.tpo_test_03.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

    @NotBlank
    @Size(min = 2)
    private String firstName;
    @NotBlank
    @Size(min = 2)
    private String lastName;

    @Email
    private String email;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

    public Teacher(){}

    public Teacher(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return teacherId;
    }

    public void setId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Course> getCourses() {
        return courses;
    }


    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
