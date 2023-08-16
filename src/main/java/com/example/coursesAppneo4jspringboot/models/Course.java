package com.example.coursesAppneo4jspringboot.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Course {

    @Id @GeneratedValue
    private Long id;
    private String identifier;
    private String title;
    private String teacher;

    /*@Relationship(direction = Relationship.Direction.INCOMING, type = "BELONGS_TO")
    private List<Lesson> lessons = new ArrayList<>();
    public List<Lesson> getLessons() {
        return lessons;
    } */

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Course() {
    } // empty constructor required for neo4j


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", identifier='" + identifier + '\'' +
                ", title='" + title + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
