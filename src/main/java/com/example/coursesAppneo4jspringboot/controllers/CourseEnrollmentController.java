package com.example.coursesAppneo4jspringboot.controllers;

import com.example.coursesAppneo4jspringboot.objects.CourseDTO;
import com.example.coursesAppneo4jspringboot.objects.CourseEnrollmentDTO;
import com.example.coursesAppneo4jspringboot.queryresults.CourseEnrollmentQueryResults;
import com.example.coursesAppneo4jspringboot.requests.CourseEnrollmentRequest;
import com.example.coursesAppneo4jspringboot.services.CourseEnrollmentService;
import com.example.coursesAppneo4jspringboot.services.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/enrollments")
public class CourseEnrollmentController {
    private final CourseEnrollmentService courseEnrollmentService;
    private final LessonService lessonService;

    public CourseEnrollmentController(CourseEnrollmentService courseEnrollmentService,
                                      LessonService lessonService) {
        this.courseEnrollmentService = courseEnrollmentService;
        this.lessonService = lessonService;
    }

    @PostMapping("/")
    public ResponseEntity<CourseEnrollmentDTO> enrollIn(@RequestBody CourseEnrollmentRequest courseEnrollmentRequest,
                                                        Principal principal){
        CourseEnrollmentQueryResults courseEnrollmentQueryResults =
                this.courseEnrollmentService.enrollIn(principal.getName(),
                        courseEnrollmentRequest.getIdentifier());
        CourseEnrollmentDTO responseCourseEnrollmentDTO = new CourseEnrollmentDTO(
                courseEnrollmentQueryResults.getUser().getUsername(),
                courseEnrollmentQueryResults.getUser().getName(),
                courseEnrollmentQueryResults.getCourse());

        return new ResponseEntity<>(responseCourseEnrollmentDTO, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Boolean> isEnrolled(@RequestBody CourseEnrollmentRequest courseEnrollmentRequest,
                                                           Principal principal){
        Boolean isEnrolled =
                this.courseEnrollmentService.getEnrollmentStatus(principal.getName(),
                        courseEnrollmentRequest.getIdentifier());

        return new ResponseEntity<>(isEnrolled, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> getAllEnrollments(Principal principal){
        List<CourseDTO> coursesResponse = this.courseEnrollmentService.getAllEnrolledCoursesForUser(principal.getName())
                .stream().map( course ->
                {
                    CourseDTO courseDTO = new CourseDTO(course.getIdentifier(), course.getTitle(), course.getTeacher());
                    courseDTO.setLessons(this.lessonService.getLessonsByCourseIdentifier(course.getIdentifier()));
                    courseDTO.setEnrolled(true);
                    return courseDTO;
                })
                .collect(Collectors.toList());
        return new ResponseEntity<>(coursesResponse, HttpStatus.OK);
    }

}
