package myproject.employee.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import myproject.employee.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
		Configuration configuration = new Configuration();
		configuration.configure("/myproject/employee/resources/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Employee employee = new Employee();
		employee.setEno(500);
		employee.setEname("Tofique");
		employee.setEsal(150000);
		employee.setEaddr("Indore");
		int pk = (Integer)session.save(employee);
		tx.commit();
		if(pk==500) {
			System.out.println("Employee Inserted Successfully");
		}
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
}
