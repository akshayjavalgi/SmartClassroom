package com.example.SmartClassroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.SmartClassroom.entity.Departments;

@Repository
@SuppressWarnings("deprecation")

public class DepartmentDao {
 
	@Autowired
	private SessionFactory factory;
	
	public List<Departments> getAllDepartments() {
		Session session =factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Departments.class);
		@SuppressWarnings("unchecked")
		List<Departments> departments=criteria.list();
		transaction.commit();
		return departments;
	}

	public Departments getDeparetmentById(long department_id) {
		Session session =factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Departments.class);
		criteria.add(Restrictions.eq("department_id", department_id));
		Departments departments=(Departments) criteria.uniqueResult();
		transaction.commit();
		return departments;
	}

	public boolean insertDepartment(Departments department) {
		Session session =factory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(department);
		transaction.commit();
		return true;
	}

	public boolean updateDepartmentByID(long department_id, String department_name) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Departments department= session.get(Departments.class, department_id);
		if (department != null) {
			department.setDepartment_name(department_name);
			session.update(department);
			transaction.commit();
			return true;
		}
		transaction.rollback();
		return false;
	}

	public boolean deleteDepartmentById(long department_id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Departments department = session.get(Departments.class, department_id);
		session.delete(department);
		transaction.commit();
		return true;
	}
	
	

}
