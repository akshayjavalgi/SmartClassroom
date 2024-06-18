package com.example.SmartClassroom.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Faculties {

	private long faculty_id;
	private String email;
	private String faculty_name;
	
	private Departments department_id;

	public Faculties() {
		
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getFaculty_id() {
		return faculty_id;
	}
	public void setFaculty_id(long faculty_id) {
		this.faculty_id = faculty_id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFaculty_name() {
		return faculty_name;
	}

	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}
	
	
	@ManyToOne
	@JoinColumn(name="department_id")
	@JsonBackReference
	public Departments getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Departments department_id) {
		this.department_id = department_id;
	}

	
	@Override
	public String toString() {
		return "Faculties [faculty_id=" + faculty_id + ", email=" + email + ", faculty_name=" + faculty_name
				+ ", department_id=" + department_id + "]";
	}
	
	
}
