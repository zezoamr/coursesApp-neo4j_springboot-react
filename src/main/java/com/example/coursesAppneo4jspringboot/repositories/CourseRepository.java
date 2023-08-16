package com.example.coursesAppneo4jspringboot.repositories;

import com.example.coursesAppneo4jspringboot.models.Course;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends Neo4jRepository<Course, Long> {

    Optional<Course> findCourseByIdentifier(String identifier);
    @Query("MATCH (u:User{username: $username})-[:ENROLLED_IN]->(courses:Course) return courses")
    List<Course> findAllEnrolledCoursesByUsername(String username);
}
