package calistir;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import bean.Personel;

public class Calistir {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.createQuery("from Personel", Personel.class).list()
				.forEach(System.out::println);
		System.out.println("***************");
		int id = 1;
		Query<Personel> query = session.createQuery("from Personel where id = ?1",
				Personel.class);
		query.setParameter(1, id);

		Personel personel = query.getSingleResult();
		System.out.println(personel);
		session.close();
	}
}
