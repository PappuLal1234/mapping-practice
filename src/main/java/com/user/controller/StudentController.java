package com.user.controller;

import com.user.entity.Student;
import com.user.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Integer studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable Integer studentId, @RequestBody Student updatedStudent) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            student.setName(updatedStudent.getName());
            // Update other fields as needed
            return studentService.saveStudent(student);
        }
        return null;
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
    }
}
