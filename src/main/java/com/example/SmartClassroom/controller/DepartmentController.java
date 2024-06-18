package com.example.SmartClassroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartClassroom.entity.Departments;
import com.example.SmartClassroom.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@GetMapping("/department")
	public List<Departments> getAllDepartments(){
		return service.getAllDepartments();
	}
	
	@GetMapping("/{department_id}")
	public Departments getDeparetmentById(@PathVariable long department_id) {
		return service.getDeparetmentById(department_id);
	}
	@PostMapping("/insert")
	public String insertDepartment(@RequestBody Departments department) {
		return service.insertDepartment(department);
	}
	
	@PostMapping("/update/{department_id}/{department_name}")
	public String updateDepartmentByID(@PathVariable long department_id,String department_name) {
		return service.updateDepartmentByID(department_id,department_name);
	}
	
	@DeleteMapping("/{department_id}")
	public String deleteDepartmentById(@PathVariable long department_id) {
		return service.deleteDepartmentById(department_id);
	}
}
