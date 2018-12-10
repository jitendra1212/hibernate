package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.nt.service.CustomJdbcConnectionProvider;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		Configuration cfg=null;
		StandardServiceRegistryBuilder builder=null;
		StandardServiceRegistry registry=null;
		//Bootstraping of Hibernate
		CustomJdbcConnectionProvider conProvider=null;
		cfg=new Configuration();
		//load both xml file(cfg file)
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create Service registryBuilder
		builder=new StandardServiceRegistryBuilder();
		//create service registry
		conProvider=new CustomJdbcConnectionProvider();
	builder.addService(ConnectionProvider.class, conProvider);
		registry=builder.applySettings(cfg.getProperties()).build();
		//build hb session factory
		factory=cfg.buildSessionFactory(registry);
		
	}
	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.openSession();
		return ses;
	}

	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
		
	}
}
