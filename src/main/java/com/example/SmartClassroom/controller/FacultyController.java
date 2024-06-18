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

import com.example.SmartClassroom.entity.Faculties;
import com.example.SmartClassroom.service.FacultyService;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

	@Autowired
	private FacultyService service;
	
	@GetMapping("/faculties")
	public List<Faculties> getAllFaculty(){
		return service.getAllFaculty();
	}
	@GetMapping("?{faculty_id}")
	public Faculties getFacultyById(@PathVariable long faculty_id) {
		return service.getFacultyById(faculty_id);
	}
	@PostMapping("/insert")
	public String inertFaculty(@RequestBody Faculties faculty) {
		return service.inertFaculty(faculty);
	}
	@PutMapping("/upadate/{faculty_id}/{faculty_name}")
	public String upadeFacultyById(@PathVariable long faculty_id,@PathVariable String faculty_name) {
		return service.upadeFacultyById(faculty_id,faculty_name);
	}
	
	@DeleteMapping("/delete/{faculty_id}")
	public String deleteFacultyById(@PathVariable long faculty_id) {
		return service.deleteFacultyById(faculty_id);
	}
	
}
