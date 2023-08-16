package com.example.coursesAppneo4jspringboot.repositories;

import com.example.coursesAppneo4jspringboot.models.User;
import com.example.coursesAppneo4jspringboot.queryresults.CourseEnrollmentQueryResults;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Optional;

public interface UserRepository extends Neo4jRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    @Query("MATCH (user:User), (course:Course) where user.username = $username AND course.identifier = $courseIdentifier "
    + "RETURN EXISTS((user)-[:ENROLLED_IN]->(course))")
    Boolean findEnrollmentStatus(String username, String courseIdentifier);

    @Query("MATCH (user:User), (course:Course) where user.username = $username AND course.identifier = $courseIdentifier "
            + "OPTIONAL MATCH (user)-[r:ENROLLED_IN]->(course) WITH user, course, r WHERE r IS NULL "
            + "CREATE (user)-[:ENROLLED_IN]->(course) return user, course")
    CourseEnrollmentQueryResults courseEnrollmentRelationship(String username, String courseIdentifier);
}
