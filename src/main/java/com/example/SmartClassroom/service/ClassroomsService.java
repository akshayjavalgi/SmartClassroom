package com.example.SmartClassroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartClassroom.dao.ClassroomsDao;
import com.example.SmartClassroom.entity.Classrooms;

@Service
public class ClassroomsService {

	@Autowired
	private ClassroomsDao dao;

	public List<Classrooms> getAllClassrooms() {
		if (dao.getAllClassrooms() != null) {
			return dao.getAllClassrooms();
		} else {
			return null;
		}
	}

	public Classrooms getClassroomsById(long classroom_id) {
		if (dao.getClassroomsById(classroom_id) != null) {
			return (Classrooms) dao.getClassroomsById(classroom_id);
		} else {
			return null;
		}
	}

	public String insertClassrooms(Classrooms classroom) {
		if (dao.insertClassrooms(classroom)) {
			return "classroom inserted successfully...";
		} else {
			return "classroom not inserted successfully...";
		}
	}

	public String updateClassroomName(long classroom_id, String class_name) {
		if (dao.updateClassroomName(classroom_id, class_name)) {
			return "Classroom Name updated successfully...";
		} else {
			return "Classroom Name not updated";
		}	
	}

	public String deleteClassroomID(long classroom_id) {
		if (dao.deleteClassroomID(classroom_id)) {
			return "Classroom deleted successfully";
		} else {
			return "Classroom not deleted";
		}

	}
}
