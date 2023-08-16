package com.example.coursesAppneo4jspringboot.controllers;

import com.example.coursesAppneo4jspringboot.models.Course;
import com.example.coursesAppneo4jspringboot.objects.CourseDTO;
import com.example.coursesAppneo4jspringboot.services.CourseEnrollmentService;
import com.example.coursesAppneo4jspringboot.services.CourseService;
import com.example.coursesAppneo4jspringboot.services.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;
    private final CourseEnrollmentService courseEnrollmentService;
    private final LessonService lessonService;

    CourseController(CourseService courseService, LessonService lessonService,
                     CourseEnrollmentService courseEnrollmentService){
        this.courseService = courseService;
        this.courseEnrollmentService = courseEnrollmentService;
        this.lessonService = lessonService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> courseIndex(Principal principal){
        List<Course> courses =  this.courseService.getAllCourses();
        List<Course> enrolledInCourses;
        if(principal != null) enrolledInCourses =
                this.courseEnrollmentService.getAllEnrolledCoursesForUser(principal.getName());
        else {
            enrolledInCourses = new ArrayList<>();
        }
        List<CourseDTO> responseCourses = courses.stream().map(course -> {
            CourseDTO responseCourse = new CourseDTO(course.getTitle(), course.getIdentifier(), course.getTeacher());
            responseCourse.setLessons(this.lessonService.getLessonsByCourseIdentifier(course.getIdentifier()));
            if(principal != null) {
                boolean isEnrolled = enrolledInCourses.stream()
                        .anyMatch(c -> c.getIdentifier().equals(course.getIdentifier()));
                responseCourse.setEnrolled(isEnrolled);
            }
            return responseCourse;
        }).collect(Collectors.toList());
        return new ResponseEntity<>(responseCourses, HttpStatus.OK);
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<CourseDTO> courseByIdentifier(@PathVariable String identifier){
        Course course = this.courseService.getCourseByIdentifier(identifier);
        CourseDTO responseCourse = new CourseDTO(course.getTitle(), course.getIdentifier(), course.getTeacher());
        responseCourse.setLessons(this.lessonService.getLessonsByCourseIdentifier(identifier));
        return new ResponseEntity<>(responseCourse, HttpStatus.OK);
    }
}
