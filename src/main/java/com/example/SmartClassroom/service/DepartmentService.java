package com.example.SmartClassroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartClassroom.dao.DepartmentDao;

import com.example.SmartClassroom.entity.Departments;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao dao;
	public List<Departments> getAllDepartments() {
		if (dao.getAllDepartments() != null) {
			return dao.getAllDepartments();
		} else {
			return null;
		}
	}
	public Departments getDeparetmentById(long department_id) {
		if (dao.getDeparetmentById(department_id) != null) {
			return (Departments) dao.getDeparetmentById(department_id);
		} else {
			return null;
		}
	}
	public String insertDepartment(Departments department) {
		if (dao.insertDepartment(department)) {
			return "department inserted successfully...";
		} else {
			return "department not inserted successfully...";
		}
	}
	public String updateDepartmentByID(long department_id,String department_name) {
		if (dao.updateDepartmentByID(department_id, department_name)) {
			return "department Name updated successfully...";
		} else {
			return "department Name not updated";
		}	
	}
	public String deleteDepartmentById(long department_id) {
		if (dao.deleteDepartmentById(department_id)) {
			return "department deleted successfully";
		} else {
			return "department not deleted";
		}
	}

}
