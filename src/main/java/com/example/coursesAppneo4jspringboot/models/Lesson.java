package com.example.coursesAppneo4jspringboot.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Lesson {

    @Id @GeneratedValue
    private Long id;

    private String identifier;

    private String title;

    public Lesson() {
    } // empty constructor required for neo4j

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

}
