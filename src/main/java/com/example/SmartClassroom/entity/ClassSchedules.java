package com.example.SmartClassroom.entity;


import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ClassSchedules {

	private long schedule_id;
	private String day_of_week;
	private LocalTime start_time;
	private LocalTime end_time;
	
    private Classrooms classroom_id;
	private Subjects subject_id;
	
	
	public ClassSchedules() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(long schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getDay_of_week() {
		return day_of_week;
	}
	public void setDay_of_week(String day_of_week) {
		this.day_of_week = day_of_week;
	}

	public LocalTime getStart_time() {
		return start_time;
	}
	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}
	
	public LocalTime getEnd_time() {
		return end_time;
	}
	public void setEnd_time(LocalTime end_time) {
		this.end_time = end_time;
	}
	
	@ManyToOne
	@JoinColumn(name="classroom_id")
	
	public Classrooms getClassroom_id() {
		return classroom_id;
	}
	public void setClassroom_id(Classrooms classroom_id) {
		this.classroom_id = classroom_id;
	}
	
	@ManyToOne
	@JoinColumn(name="subject_id")
	
	public Subjects getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(Subjects subject_id) {
		this.subject_id = subject_id;
	}
	
	
	@Override
	public String toString() {
		return "ClassSchedules [schedule_id=" + schedule_id + ", day_of_week=" + day_of_week + ", start_time="
				+ start_time + ", end_time=" + end_time + ", classroom_id=" + classroom_id + ", subject_id="
				+ subject_id + "]";
	}
	
	
}
