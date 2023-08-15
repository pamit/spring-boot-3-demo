package com.pamit.springbootdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "courses")
public class Course {
    @Id
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;

    public Course() {
        this.id = 1L;
        this.title = "";
        this.author = "";
    }

    public Course(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Course [id=%s, title=%s, author=%s]", id, title, author);
    }
}
