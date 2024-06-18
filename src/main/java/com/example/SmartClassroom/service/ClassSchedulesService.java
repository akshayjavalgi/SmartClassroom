package com.example.SmartClassroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartClassroom.dao.ClassSchedulesDao;
import com.example.SmartClassroom.entity.ClassSchedules;
import com.example.SmartClassroom.entity.Classrooms;

@Service
public class ClassSchedulesService {

	@Autowired
	private ClassSchedulesDao dao;
	public List<ClassSchedules> getAllClassSchedules() {
		if (dao.getAllClassSchedules() != null) {
			return dao.getAllClassSchedules();
		} else {
			return null;
		}
	}
	public String insertClassSchedules(ClassSchedules classschedules) {
		if (dao.insertClassSchedules(classschedules)) {
			return "classschedules inserted successfully...";
		} else {
			return "classschedules not inserted successfully...";
		}
	}
	public ClassSchedules getClassScheduleById(long schedule_id) {
		if (dao.getClassScheduleById(schedule_id) != null) {
			return dao.getClassScheduleById(schedule_id);
		} else {
			return null;
		}
	}
	public String updateDayOfWeekById(long schedule_id, String day_of_week) {
		if (dao.updateDayOfWeekById(schedule_id, day_of_week)) {
			return "Day updated successfully...";
		} else {
			return "ID not updated";
		}	
	}
	public String deleteClassScheduleByID(long schedule_id) {
		if (dao.deleteClassScheduleByID(schedule_id)) {
			return "classschedule deleted successfully";
		} else {
			return "classschedule not deleted";
		}
	}

}
