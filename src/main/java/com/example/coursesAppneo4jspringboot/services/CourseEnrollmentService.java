package com.example.coursesAppneo4jspringboot.services;

import com.example.coursesAppneo4jspringboot.models.Course;
import com.example.coursesAppneo4jspringboot.queryresults.CourseEnrollmentQueryResults;
import com.example.coursesAppneo4jspringboot.repositories.CourseRepository;
import com.example.coursesAppneo4jspringboot.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseEnrollmentService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseEnrollmentService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public Boolean getEnrollmentStatus(String username, String courseIdentifier){
        return this.userRepository.findEnrollmentStatus(username, courseIdentifier);
    }

    public CourseEnrollmentQueryResults enrollIn(String username, String courseIdentifier)
            throws ResponseStatusException {
        CourseEnrollmentQueryResults courseEnrollmentQueryResults =
                this.userRepository.courseEnrollmentRelationship(username, courseIdentifier);
        if(courseEnrollmentQueryResults == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "user already enrolled in the course or course not found");
        return courseEnrollmentQueryResults;
    }

    public List<Course> getAllEnrolledCoursesForUser(String username){
        return this.courseRepository.findAllEnrolledCoursesByUsername(username);
    }
}
