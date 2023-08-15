package com.example.coursesAppneo4jspringboot.services;

import com.example.coursesAppneo4jspringboot.models.Lesson;
import com.example.coursesAppneo4jspringboot.repositories.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getLessonsByCourseIdentifier(String identifier) {
        return this.lessonRepository.findLessonsByCourseIdentifier(identifier);
    }

}
