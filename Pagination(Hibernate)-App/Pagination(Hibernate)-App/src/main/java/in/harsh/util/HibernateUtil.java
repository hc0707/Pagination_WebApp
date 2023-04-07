package in.harsh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.harsh.model.Flowers;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;
	private HibernateUtil() {}
	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(Flowers.class).buildSessionFactory();
	}
	public static Session getSession() {
		if (session == null) {
			session = sessionFactory.openSession();
			
		}
		return session;
	}
	public static void closeSession(Session session) {
		if (session != null)
			session.close();
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null)
			sessionFactory.close();
	}
	
}
