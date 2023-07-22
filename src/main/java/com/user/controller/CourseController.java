package com.user.controller;
import com.user.entity.Course;
import com.user.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable Integer courseId) {
        return courseService.getCourseById(courseId);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @PutMapping("/{courseId}")
    public Course updateCourse(@PathVariable Integer courseId, @RequestBody Course updatedCourse) {
        Course course = courseService.getCourseById(courseId);
        if (course != null) {
            course.setTitle(updatedCourse.getTitle());
            // Update other fields as needed
            return courseService.saveCourse(course);
        }
        return null;
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable Integer courseId) {
        courseService.deleteCourse(courseId);
    }
}