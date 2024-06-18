package com.example.SmartClassroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartClassroom.entity.ClassSchedules;
import com.example.SmartClassroom.service.ClassSchedulesService;

@RestController
@RequestMapping("/classSchedule")
public class ClassSchedulesController {

	@Autowired
	private ClassSchedulesService service;
	
	@GetMapping("/classShcedules")
	public List<ClassSchedules> getAllClassSchedules() {
		return service.getAllClassSchedules();
	}
	
	@GetMapping("/classShcedules/{schedule_id}")
	public ClassSchedules getClassScheduleById(@PathVariable long schedule_id) {
		return service.getClassScheduleById(schedule_id);
	}
	
	@PostMapping(value="/insert", consumes ="application/json")
	public String insertClassSchedules(@RequestBody ClassSchedules classschedules) {
		return service.insertClassSchedules(classschedules);
	}
	@PutMapping("updateDay/{schedule_id}/{day_of_week}")
	public String updateDayOfWeekById(@PathVariable long schedule_id, @PathVariable String day_of_week) {
		return service.updateDayOfWeekById(schedule_id, day_of_week);
	}
	
	@DeleteMapping("/delete/{schedule_id}")
	public String deleteClassScheduleByID(@PathVariable long schedule_id) {
		return service.deleteClassScheduleByID(schedule_id);
	}
	
}
