package com.example.SmartClassroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartClassroom.dao.FacultyDao;

import com.example.SmartClassroom.entity.Faculties;

@Service
public class FacultyService {

	@Autowired
	private FacultyDao dao;
	public List<Faculties> getAllFaculty() {
		if (dao.getAllFaculty() != null) {
			return dao.getAllFaculty();
		} else {
			return null;
		}
	}
	public Faculties getFacultyById(long faculty_id) {
		if (dao.getFacultyById(faculty_id) != null) {
			return (Faculties) dao.getFacultyById(faculty_id);
		} else {
			return null;
		}
	}
	public String inertFaculty(Faculties faculty) {
		if (dao.inertFaculty(faculty)) {
			return "faculty inserted successfully...";
		} else {
			return "faculty not inserted successfully...";
		}
	}
	public String upadeFacultyById(long faculty_id, String faculty_name) {
		if (dao.upadeFacultyById(faculty_id, faculty_name)) {
			return "faculty Name updated successfully...";
		} else {
			return "faculty Name not updated";
		}	
	}
	public String deleteFacultyById(long faculty_id) {
		if (dao.deleteFacultyById(faculty_id)) {
			return "faculty deleted successfully";
		} else {
			return "faculty not deleted";
		}
	}

}
