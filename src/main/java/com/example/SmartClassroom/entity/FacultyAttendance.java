package com.example.SmartClassroom.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity 
public class FacultyAttendance {

	private long faculty_Attendance_id;
	private LocalDate date;
	private String status;
	
	private Faculties faculty_id;
	private ClassSchedules schedule_id;
	
	public FacultyAttendance(long faculty_Attendance_id, LocalDate date, String status, Faculties faculty_id,
			ClassSchedules schedule_id) {
		this.faculty_Attendance_id = faculty_Attendance_id;
		this.date = date;
		this.status = status;
		this.faculty_id = faculty_id;
		this.schedule_id = schedule_id;
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getFaculty_Attendance_id() {
		return faculty_Attendance_id;
	}
	public void setFaculty_Attendance_id(long faculty_Attendance_id) {
		this.faculty_Attendance_id = faculty_Attendance_id;
	}

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@ManyToOne
	@JoinColumn(name="faculty_id")
	@JsonBackReference
	public Faculties getFaculty_id() {
		return faculty_id;
	}
	public void setFaculty_id(Faculties faculty_id) {
		this.faculty_id = faculty_id;
	}
	
	@ManyToOne
	@JoinColumn(name="schedule_id")
	@JsonBackReference
	public ClassSchedules getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(ClassSchedules schedule_id) {
		this.schedule_id = schedule_id;
	}
	
	
	@Override
	public String toString() {
		return "FacultyAttendance [faculty_Attendance_id=" + faculty_Attendance_id + ", date=" + date + ", status="
				+ status + ", faculty_id=" + faculty_id + ", schedule_id=" + schedule_id + "]";
	}
	
	
}
