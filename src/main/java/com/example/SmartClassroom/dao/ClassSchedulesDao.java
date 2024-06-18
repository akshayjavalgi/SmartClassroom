package com.example.SmartClassroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.SmartClassroom.entity.ClassSchedules;


@Repository
@SuppressWarnings("deprecation")
public class ClassSchedulesDao {

	@Autowired
	private SessionFactory factory;

	public List<ClassSchedules> getAllClassSchedules() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(ClassSchedules.class);
		@SuppressWarnings("unchecked")
		List<ClassSchedules> list = criteria.list();
		transaction.commit();
		return list;
	}
	public boolean insertClassSchedules(ClassSchedules classschedules) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(classschedules);
		transaction.commit();
		return true;
	}
	public ClassSchedules getClassScheduleById(long schedule_id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(ClassSchedules.class);
		criteria.add(Restrictions.eq("schedule_id", schedule_id));
		ClassSchedules classSchedules = (ClassSchedules) criteria.uniqueResult();
		transaction.commit();
		return classSchedules;
	}
	public boolean updateDayOfWeekById(long schedule_id, String day_of_week) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		ClassSchedules classSchedules= session.get(ClassSchedules.class, schedule_id);
		if (classSchedules != null) {
			classSchedules.setDay_of_week(day_of_week);
			session.update(classSchedules);
			transaction.commit();
			return true;
		}
		transaction.rollback();
		return false;
	}
	public boolean deleteClassScheduleByID(long schedule_id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		ClassSchedules classSchedules = session.get(ClassSchedules.class, schedule_id);
		session.delete(classSchedules);
		transaction.commit();
		return true;
	}
	
	
}
