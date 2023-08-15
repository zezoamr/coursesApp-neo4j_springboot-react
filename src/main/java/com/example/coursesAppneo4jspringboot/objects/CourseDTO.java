package com.example.coursesAppneo4jspringboot.objects;

import com.example.coursesAppneo4jspringboot.models.Lesson;

import java.util.ArrayList;
import java.util.List;

public class CourseDTO {
    private String identifier;
    private String title;
    private String teacher;
    private List<Lesson> lessons = new ArrayList<>();

    public CourseDTO(String identifier, String title, String teacher) {
        this.identifier = identifier;
        this.title = title;
        this.teacher = teacher;
    }


    public String getIdentifier() {
        return identifier;
    }

    public String getTitle() {
        return title;
    }

    public String getTeacher() {
        return teacher;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
