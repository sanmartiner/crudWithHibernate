import java.util.Date;

import com.br.crudhibernate.dao.StudentDao;
import com.br.crudhibernate.model.Student;

public class App {
	public static void main(String[] args) {
		Student student = new Student();
		StudentDao studentDao = new StudentDao();

		/**
		 * Test save
		 */
		Student student1 = new Student();
		student1.setName("Martin");
		student1.setEmail("sam@college.com");
		student1.setAddress("R. San Francisco, 469");
		student1.setLastName("Luther");

		studentDao.save(student1);

		/**
		 * Test update
		 */
		Student student2 = new Student();
		student1.setName("Mendez");
		student1.setEmail("sam@college.com");
		student1.setAddress("R. San Francisco, 469");
		student1.setLastName("Adam");

		studentDao.update(student2);

		/**
		 * Test list Students
		 */

		for (Student s : studentDao.getAllStudents()) {
			System.out.println("Student: " + s.getName());
		}

		/**
		 * Delete by Id
		 */

		studentDao.deleteByID(2);

	}
}
