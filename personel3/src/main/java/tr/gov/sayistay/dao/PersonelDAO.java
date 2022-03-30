package tr.gov.sayistay.dao;

import java.util.List;

import org.hibernate.Session;

import tr.gov.sayistay.entity.Personel;
import tr.gov.sayistay.util.HibernateUtil;

public class PersonelDAO {
	public List<Personel> getPersoneller() {
		try (Session session = HibernateUtil.getSession()) {
			return session.createQuery("from Personel", Personel.class).list();
		}
	}
}
