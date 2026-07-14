package pja.edu.pl.s30855.tpo_test_03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pja.edu.pl.s30855.tpo_test_03.models.Course;
import pja.edu.pl.s30855.tpo_test_03.models.Teacher;
import pja.edu.pl.s30855.tpo_test_03.services.MyService;

import java.util.List;

@Controller
@RequestMapping("/school")
public class SchoolController {

    private final MyService service;

    public SchoolController(MyService service){
        this.service = service;
    }

    @GetMapping("/home")
    public String showHomePage(Model model){
        model.addAttribute("teacherId", "");
        model.addAttribute("courseId", "");
        return "home";
    }

    @GetMapping("/course/{id}")
    public String getCourseDetails(@PathVariable Long id, Model model){
        Course course = service.getCourseById(id);
        if(course == null){
            return "home";
        }
        model.addAttribute("course", course);
        return "course-details";
    }

    @GetMapping("/teacher/{id}")
    public String getTeacherDetails(@PathVariable Long id, Model model){
        Teacher teacher = service.getTeacherById(id);
        if(teacher == null){
            return "home";
        }
        model.addAttribute("teacher", teacher);
        return "teacher-details";
    }

    @GetMapping("/courses")
    public String getAllCourses(Model model){
        List<Course> courses = service.getAllCourses();
        if(courses == null){
            return "home";
        }
        model.addAttribute("courses", courses);
        return "all-courses";
    }


    @GetMapping("/teachers")
    public String getAllTeachers(Model model){
        List<Teacher> teachers = service.getAllTeachers();
        if(teachers == null){
            return "home";
        }
        model.addAttribute("teachers", teachers);
        return "all-teachers";
    }

    @DeleteMapping("/delete/teacher/{teacherId}")
    public String deleteTeacher( @PathVariable Long teacherId){
        service.deleteTeacher(teacherId);
        return "result";
    }

    @DeleteMapping("/delete/course/{courseId}")
    public String deleteCourse( @PathVariable Long courseId){
        service.deleteCourse(courseId);
        return "result";
    }
}
