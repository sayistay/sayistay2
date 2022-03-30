package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;

	private static SessionFactory getSessionFactory() {
		if (factory == null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
		return factory;
	}

	public static Session getSession() {
		return getSessionFactory().openSession();
//		Session session = getSessionFactory().getCurrentSession();
//		if (session == null) {
//			session = getSessionFactory().openSession();
//		}
//		return session;
	}
}
