package com.example.SmartClassroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.SmartClassroom.entity.Subjects;

@Repository
@SuppressWarnings("deprecation")
public class SubjectDao {

	@Autowired
	private SessionFactory factory;
	public Object getAllSubjects() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
	
		Criteria criteria = session.createCriteria(Subjects.class);
		@SuppressWarnings("unchecked")
		List<Subjects> list = criteria.list();
		transaction.commit();
		return list;
	}
	public Subjects getSubjectById(long subject_id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Subjects.class);
		criteria.add(Restrictions.eq("subject_id", subject_id));
		Subjects subject = (Subjects) criteria.uniqueResult();
		transaction.commit();
		return subject;
	}
	public boolean insertSubject(Subjects subject) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(subject);
		transaction.commit();
		return true;
	}
	public boolean upadatesubjectById(long subject_id, String subject_name) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Subjects subject= session.get(Subjects.class, subject_id);
		if (subject != null) {
			subject.setSubject_name(subject_name);
			session.update(subject);
			transaction.commit();
			return true;
		}
		transaction.rollback();
		return false;
	}
	public boolean deleteSubjectById(long subject_id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Subjects subject = session.get(Subjects.class, subject_id);
		session.delete(subject);
		transaction.commit();
		return true;
	}
	
	

}
