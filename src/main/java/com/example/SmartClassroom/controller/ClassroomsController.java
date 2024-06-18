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

import com.example.SmartClassroom.entity.Classrooms;
import com.example.SmartClassroom.service.ClassroomsService;

@RestController
@RequestMapping("/classroom")
public class ClassroomsController {

	@Autowired
	private ClassroomsService service;
	
	@GetMapping("/classrooms")
	public List<Classrooms> getAllClassrooms() {
		return service.getAllClassrooms();
	}
	
	@GetMapping("/classrooms/{classroom_id}")
	public Classrooms getClassroomsById(@PathVariable long classroom_id) {
		return service.getClassroomsById(classroom_id);
	}
	
	@PostMapping("/classrooms")
	public String insertClassrooms(@RequestBody Classrooms classroom) {
		return service.insertClassrooms(classroom);
	}
	
	@PutMapping("update/{classroom_id}/{class_name}")
	public String updateClassroomName(@PathVariable long classroom_id, @PathVariable String class_name) {
		return service.updateClassroomName(classroom_id, class_name);
	}
	
	@DeleteMapping("/delete/{productId}")
	public String deleteClassroomID(@PathVariable long classroom_id) {
		return service.deleteClassroomID(classroom_id);
	}
}
