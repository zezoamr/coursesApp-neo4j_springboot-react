package com.example.coursesAppneo4jspringboot.repositories;

import com.example.coursesAppneo4jspringboot.models.Lesson;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface LessonRepository extends Neo4jRepository<Lesson, Long> {

    @Query("MATCH (:Course {identifier: $identifier}) <-[:BELONGS_TO]- (lessons:Lesson) RETURN lessons")
    List<Lesson> findLessonsByCourseIdentifier(String identifier);

}
