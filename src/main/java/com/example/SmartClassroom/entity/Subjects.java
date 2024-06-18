package com.example.SmartClassroom.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Subjects {

	private long subject_id;
	private String subject_name;
	 
	private Faculties faculty_id;
	private Courses course_id;

	public Subjects() {
		
	}
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(long subject_id) {
		this.subject_id = subject_id;
	}


	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	@ManyToOne
    @JoinColumn(name = "faculty_id")
	public Faculties getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(Faculties faculty_id) {
		this.faculty_id = faculty_id;
	}

	@ManyToOne
	@JoinColumn(name="course_id")
	@JsonBackReference
	public Courses getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Courses course_id) {
		this.course_id = course_id;
	}

	@Override
	public String toString() {
		return "Subjects [subject_id=" + subject_id + ", subject_name=" + subject_name + ", faculty_id=" + faculty_id
				+ ", course_id=" + course_id + "]";
	}
	
	
}
