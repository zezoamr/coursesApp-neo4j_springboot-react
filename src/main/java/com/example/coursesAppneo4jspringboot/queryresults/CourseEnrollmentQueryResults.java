package com.example.coursesAppneo4jspringboot.queryresults;

import com.example.coursesAppneo4jspringboot.models.Course;
import com.example.coursesAppneo4jspringboot.models.User;

public class CourseEnrollmentQueryResults {

    private User user;
    private Course course;

    public CourseEnrollmentQueryResults() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseEnrollmentQueryResults{" +
                "user=" + user +
                ", course=" + course +
                '}';
    }
}
