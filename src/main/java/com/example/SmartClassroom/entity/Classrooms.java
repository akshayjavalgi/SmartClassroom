package com.example.SmartClassroom.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classrooms {

	private long classroom_id;
	private String class_name;
	
	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	public long getClassroom_id() {
		return classroom_id;
	}
	public void setClassroom_id(long classroom_id) {
		this.classroom_id = classroom_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	@Override
	public String toString() {
		return "Classrooms [classroom_id=" + classroom_id + ", class_name=" + class_name + "]";
	}
}
