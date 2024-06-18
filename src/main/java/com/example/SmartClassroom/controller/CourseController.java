package com.example.SmartClassroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartClassroom.entity.Courses;
import com.example.SmartClassroom.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@Autowired
	private CourseService service;
	
	@GetMapping("/courses")
	public List<Courses> getAllCourses(){
		return service.getAllCourses();
	}
	
	@GetMapping("/{course_id}")
	public Courses getCourseById(@PathVariable long course_id) {
		return service.getCourseById(course_id);
	}
	
	@PostMapping("/insert")
	public String insertCourse(@RequestBody Courses course) {
		return service.insertCourse(course);
	}
	@PutMapping("/update/{course_id}/{course_name}")
	public String UpdateCourseById(@PathVariable long course_id,String course_name) {
		return service.UpdateCourseById(course_id,course_name);
	}
	@DeleteMapping("/delete/{course_id}")
	public String deleteCourseById(@PathVariable long course_id) {
		return service.deleteCourseById(course_id);
	}
}
