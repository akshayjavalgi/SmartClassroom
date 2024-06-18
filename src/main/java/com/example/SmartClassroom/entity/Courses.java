package com.example.SmartClassroom.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Courses {

	private long course_id;
	private String course_name;
	
	private Departments department_id;
	
	public Courses() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	@ManyToOne
	@JoinColumn(name="depaertment_id")
	@JsonBackReference
	public Departments getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Departments department_id) {
		this.department_id = department_id;
	}
	@Override
	public String toString() {
		return "Courses [course_id=" + course_id + ", course_name=" + course_name + "]";
	}
	
	
	
}
