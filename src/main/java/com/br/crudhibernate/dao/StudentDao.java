package com.br.crudhibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.br.crudhibernate.model.Student;
import com.br.crudhibernate.util.HibernateUtil;

public class StudentDao {

	Student student = new Student();

	public void save(Student student) {
		Transaction transaction = null;
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.save(student);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void update(Student student) {
		Transaction transaction = null;
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.saveOrUpdate(student);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudent() {
		Transaction transaction = null;
		List<Student> students = null;
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			students = session.createQuery("from Student").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return students;
	}

	public Student getStudentByID(long id) {
		Transaction transaction = null;
		Student student = null;
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			student = session.get(Student.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return student;
	}

	public void delete(long id) {
		Transaction transaction = null;
		Student student = null;
		try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			student = session.get(Student.class, id);

			session.delete(student);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

}
