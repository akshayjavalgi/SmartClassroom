package com.example.SmartClassroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.SmartClassroom.entity.Courses;

@Repository
@SuppressWarnings("deprecation")
public class CourseDao {

	@Autowired
	private SessionFactory factory;

	public List<Courses> getAllCourses() {
		Session session =factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Courses.class);
		@SuppressWarnings("unchecked")
		List<Courses> list=criteria.list();
		transaction.commit();
		return list;
	}

	public Courses getCourseById(long course_id) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Courses.class);
		criteria.add(Restrictions.eq("course_id", course_id));
		Courses courses=(Courses) criteria.uniqueResult();
		transaction.commit();
		return courses;
	}

	public boolean insertCourse(Courses course) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(course);
		transaction.commit();
		return true;
	}

	public boolean UpdateCourseById(long course_id, String course_name) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Courses courses= session.get(Courses.class, course_id);
		if (courses != null) {
			courses.setCourse_name(course_name);
			session.update(courses);
			transaction.commit();
			return true;
		}
		transaction.rollback();
		return false;
	}

	public boolean deleteCourseById(long course_id) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Courses courses=session.get(Courses.class, course_id);
		session.delete(courses);
		transaction.commit();
		return true;
	}
	
	
}
