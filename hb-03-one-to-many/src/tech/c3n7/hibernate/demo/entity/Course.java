package tech.c3n7.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
    // define our fields
    // define constructors
    // define getters setters
    // define to string
    // anotate fields

    private int id;

    private String title;

    private Instructor instructor;

    public Course() {

    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
