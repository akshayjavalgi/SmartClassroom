package com.example.SmartClassroom.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Departments {

	private long department_id;
	private String department_name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(long department_id) {
		this.department_id = department_id;
	} 
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	
	
	@Override
	public String toString() {
		return "Departments [department_id=" + department_id + ", department_name=" + department_name + "]";
	}
	
	
	
}
