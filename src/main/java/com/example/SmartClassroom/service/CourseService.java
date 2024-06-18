package com.example.SmartClassroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartClassroom.dao.CourseDao;
import com.example.SmartClassroom.entity.Courses;

@Service
public class CourseService {

	@Autowired
	private CourseDao dao;

	public List<Courses> getAllCourses() {
		if (dao.getAllCourses() != null) {
			return dao.getAllCourses();
		} else {
			return null;
		}
	}

	public Courses getCourseById(long course_id) {
		if (dao.getCourseById(course_id) != null) {
			return dao.getCourseById(course_id);
		} else {
			return null;
		}
	}

	public String insertCourse(Courses course) {
		if (dao.insertCourse(course)) {
			return "course inserted successfully...";
		} else {
			return "course not inserted successfully...";
		}
	}

	public String UpdateCourseById(long course_id, String course_name) {
		if (dao.UpdateCourseById(course_id, course_name)) {
			return "course Name updated successfully...";
		} else {
			return "course Name not updated";
		}	
	}

	public String deleteCourseById(long course_id) {
		if (dao.deleteCourseById(course_id)) {
			return "course deleted successfully";
		} else {
			return "course not deleted";
		}
	}
	
	
}
