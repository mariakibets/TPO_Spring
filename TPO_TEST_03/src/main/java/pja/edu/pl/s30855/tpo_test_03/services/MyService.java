package pja.edu.pl.s30855.tpo_test_03.services;

import org.springframework.stereotype.Service;
import pja.edu.pl.s30855.tpo_test_03.models.Course;
import pja.edu.pl.s30855.tpo_test_03.models.Teacher;
import pja.edu.pl.s30855.tpo_test_03.repositories.CourseRepository;
import pja.edu.pl.s30855.tpo_test_03.repositories.TeacherRepository;

import java.util.List;

@Service
public class MyService {

    private final CourseRepository courseRepository;

    private final TeacherRepository teacherRepository;


    public MyService(CourseRepository courseRepository, TeacherRepository teacherRepository){
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }

    public Teacher getTeacherById(Long id){
        Teacher teacher = teacherRepository.findById(id);
        return teacher;
    }

    public Course getCourseById(Long id){
        Course course = courseRepository.findById(id);
        return course;
    }

    public List<Teacher> getAllTeachers(){
        List<Teacher> teachers = teacherRepository.getAll();
        return teachers;
    }

    public List<Course> getAllCourses(){
        List<Course> courses = courseRepository.getAll();
        return courses;
    }

    public void deleteTeacher(Long id){
        teacherRepository.deleteById(id);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }


}
