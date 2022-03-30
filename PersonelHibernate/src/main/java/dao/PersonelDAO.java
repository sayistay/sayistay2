package dao;

import java.util.List;

import org.hibernate.Session;

import bean.Personel;
import util.HibernateUtil;

public class PersonelDAO {
	public List<Personel> getPersoneller() {
		try (Session session = HibernateUtil.getSession()) {
			return session.createQuery("from Personel", Personel.class).list();
		}
	}
}
