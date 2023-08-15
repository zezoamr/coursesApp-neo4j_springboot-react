package com.example.coursesAppneo4jspringboot.services;

import com.example.coursesAppneo4jspringboot.models.Course;
import com.example.coursesAppneo4jspringboot.repositories.CourseRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses(){
        return this.courseRepository.findAll();
    }

    public Course getCourseByIdentifier(String identifier) throws ResponseStatusException {
        return this.courseRepository.findCourseByIdentifier(identifier)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
    }

}
