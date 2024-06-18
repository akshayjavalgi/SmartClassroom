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

import com.example.SmartClassroom.entity.Subjects;
import com.example.SmartClassroom.service.SubjectService;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

	@Autowired
	private SubjectService service;
	
	@GetMapping("/subjects")
	public List<Subjects> getAllSubjects(){
		return service.getAllSubjects();
	}
	
	@GetMapping("/{subject_id}")
	public Subjects getSubjectById(@PathVariable long subject_id) {
		return service.getSubjectById(subject_id);
	}
	
	@PostMapping("/inser")
	public String insertSubject(@RequestBody Subjects subject) {
		return service.insertSubject(subject);
	}
	@PutMapping("/update/{subject_id}/{subject_name}")
	public String upadatesubjectById(@PathVariable long subject_id,@PathVariable String subject_name) {
		return service.upadatesubjectById(subject_id,subject_name);
	}
	@DeleteMapping("/delete/{subject_id}")
	public String deleteSubjectById(@PathVariable long subject_id) {
		return service.deleteSubjectById(subject_id);
	}
}
