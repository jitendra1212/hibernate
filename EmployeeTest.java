package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.nt.entity.EmployeeDetails;
import com.nt.utility.HibernateUtil;

public class EmployeeTest {
	public static void main(String[] args) {
		Session ses=null;
		boolean flag=false;
		Transaction tx= null;
	
		EmployeeDetails emp=null;
		int idval=0;
		ses=HibernateUtil.getSession();
		
		try {
			tx=ses.beginTransaction();
			emp=new EmployeeDetails();
		    
		    emp.setFirstName("jitendra");
		    emp.setLastName("bansal");
		    emp.setEmail("bansal@gmail.com");
			idval=(int) ses.save(emp);
			System.out.println("id value="+idval);
			flag=true;
		}
		catch(HibernateException hb) {
			hb.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
			System.out.println("object is saved");
			}
			else {
				tx.rollback();
				System.out.println("object is not saved");
			}
			//close connection
		
		}
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}

}
