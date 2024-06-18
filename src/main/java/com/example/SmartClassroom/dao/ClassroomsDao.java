package com.example.SmartClassroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.SmartClassroom.entity.Classrooms;

@Repository
@SuppressWarnings("deprecation")
public class ClassroomsDao {

	@Autowired
	private SessionFactory factory;

	
	public List<Classrooms> getAllClassrooms() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Classrooms.class);
		@SuppressWarnings("unchecked")
		List<Classrooms> list = criteria.list();
		transaction.commit();
		return list;
	}

	public Classrooms getClassroomsById(long classroom_id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Classrooms.class);
		criteria.add(Restrictions.eq("classroom_id", classroom_id));
		Classrooms classroom = (Classrooms) criteria.uniqueResult();
		transaction.commit();
		return classroom;
	}

	public boolean insertClassrooms(Classrooms classroom) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(classroom);
		transaction.commit();
		return true;
	}

	public boolean updateClassroomName(long classroom_id, String class_name) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Classrooms classroom= session.get(Classrooms.class, classroom_id);
		if (classroom != null) {
			classroom.setClass_name(class_name);
			session.update(classroom);
			transaction.commit();
			return true;
		}
		transaction.rollback();
		return false;
	}

	public boolean deleteClassroomID(long classroom_id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Classrooms classroom = session.get(Classrooms.class, classroom_id);
		session.delete(classroom);
		transaction.commit();
		return true;
	}
}
