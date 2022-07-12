package tech.c3n7.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.c3n7.springdemo.entity.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("John", "Doe"));
        students.add(new Student("Ann", "Dean"));
        students.add(new Student("Moana", "Anita"));
    }

    // define endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // define endpoint for "/student/{studentId}"
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // check student id
        if ((studentId >= students.size() || studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }
}
