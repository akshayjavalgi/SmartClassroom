package com.example.SmartClassroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartClassroom.dao.SubjectDao;
import com.example.SmartClassroom.entity.Subjects;

@Service
public class SubjectService {

	@Autowired
	private SubjectDao dao;
	@SuppressWarnings("unchecked")
	public List<Subjects> getAllSubjects() {
		if (dao.getAllSubjects() != null) {
			return (List<Subjects>) dao.getAllSubjects();
		} else {
			return null;
		}
	}
	public Subjects getSubjectById(long getSubjectById) {
		if (dao.getSubjectById(getSubjectById) != null) {
			return (Subjects) dao.getSubjectById(getSubjectById);
		} else {
			return null;
		}
	}
	public String insertSubject(Subjects subject) {
		if (dao.insertSubject(subject)) {
			return "subject inserted successfully...";
		} else {
			return "subject not inserted successfully...";
		}
	}
	public String upadatesubjectById(long subject_id, String subject_name) {
		if (dao.upadatesubjectById(subject_id, subject_name)) {
			return "subject Name updated successfully...";
		} else {
			return "subject Name not updated";
		}	
	}
	public String deleteSubjectById(long subject_id) {
		if (dao.deleteSubjectById(subject_id)) {
			return "subject deleted successfully";
		} else {
			return "subject not deleted";
		}
	}

}
