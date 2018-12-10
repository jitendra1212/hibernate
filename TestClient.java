package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class TestClient {
	public static void main(String[] args) {
		Session ses = null;
		boolean flag= false;
		Transaction tx= null;
		Employee emp = null;
		int idval=0;
		ses=HibernateUtil.getSession();
		try {
			tx= ses.beginTransaction();
			emp= new Employee();
			emp.setEid(199);
			emp.setEmail("bansal@gmail.com");
			emp.setFirstName("jitendra");
			emp.setLastName("bansal");
   idval=(int) ses.save(emp);
   flag=true;
   System.out.println(idval);
		}
		catch(HibernateException hb) {
			hb.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=true;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("object is savved");
			}
			else {
				tx.rollback();
				System.out.println("object is not saved");
			}
		
			HibernateUtil.closeSessionFactory();
			HibernateUtil.closeSession(ses);
		}
	}

}
