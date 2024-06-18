package com.example.SmartClassroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.SmartClassroom.entity.Faculties;

@Repository
@SuppressWarnings("deprecation")
public class FacultyDao {

	@Autowired
	private SessionFactory factory;
	
	public List<Faculties> getAllFaculty() {
		Session session =factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Faculties.class);
		@SuppressWarnings("unchecked")
		List<Faculties> faculties=criteria.list();
		transaction.commit();
		return faculties;
		
	}

	public Faculties getFacultyById(long faculty_id) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Faculties.class);
		criteria.add(Restrictions.eq("faculty_id", faculty_id));
		Faculties faculties=(Faculties) criteria.uniqueResult();
		transaction.commit();
		return faculties;
	}

	public boolean inertFaculty(Faculties faculty) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(faculty);
		transaction.commit();
		return true;
	}

	public boolean upadeFacultyById(long faculty_id, String faculty_name) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Faculties faculty= session.get(Faculties.class, faculty_id);
		if (faculty != null) {
			faculty.setFaculty_name(faculty_name);
			session.update(faculty);
			transaction.commit();
			return true;
		}
		transaction.rollback();
		return false;
	}

	public boolean deleteFacultyById(long faculty_id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Faculties faculty = session.get(Faculties.class, faculty_id);
		session.delete(faculty);
		transaction.commit();
		return true;
	}

}
