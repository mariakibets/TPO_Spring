package pja.edu.pl.s30855.tpo_test_03.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String name;

    @ManyToOne
    private Teacher teacher;

    public Course(){}

    public Course(String name, Teacher teacher){
        this.name = name;
        this.teacher = teacher;
    }

    public void setId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
