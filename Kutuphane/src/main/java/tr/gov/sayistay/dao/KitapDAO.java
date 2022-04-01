package tr.gov.sayistay.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tr.gov.sayistay.entity.Kitap;
import tr.gov.sayistay.util.HibernateUtil;

public class KitapDAO {
	public long getKitapSayisi() {
		return HibernateUtil.getSession().createNamedQuery("kitapSayisi", Long.class)
				.getSingleResult();
	}

	public Kitap kitapOlustur(Kitap kitap) {
		Kitap kaydedilenKitap = null;
		Transaction tx = null;
		try {
			Session session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			kaydedilenKitap = session.merge(kitap);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return kaydedilenKitap;
	}

	public List<Kitap> getKitaplar(int yazarId) {
		return HibernateUtil.getSession().createNamedQuery("getKitaplarByYazarId", Kitap.class)
				.setParameter(1, yazarId).list();
	}

}
