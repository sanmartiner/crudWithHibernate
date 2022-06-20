package com.br.crudhibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.br.crudhibernate.model.Student;
import com.br.crudhibernate.util.HibernateUtil;

public class StudentDao {

	Student student = new Student();

	public void save(Student student) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.save(student);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

}
