package tr.gov.sayistay.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tr.gov.sayistay.entity.Yazar;
import tr.gov.sayistay.util.HibernateUtil;

public class YazarDAO {
	public long getYazarSayisi() {
		return HibernateUtil.getSession().createNamedQuery("yazarSayisi", Long.class)
				.getSingleResult();
	}

	public Yazar yazarOlustur(Yazar yazar) {
		Yazar kaydedilenYazar = null;
		Transaction tx = null;
		try {
			Session session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			kaydedilenYazar = session.merge(yazar);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return kaydedilenYazar;
	}

	public Yazar getYazar(String adi, String soyadi) {
		return HibernateUtil.getSession().createNamedQuery("getYazarByAdiSoyadi", Yazar.class)
				.setParameter(1, adi).setParameter(2, soyadi).getSingleResultOrNull();
	}

	public List<Yazar> getYazarlar() {
		return HibernateUtil.getSession().createNamedQuery("getTumYazarlar", Yazar.class)
				.list();
	}

	public Yazar kaydet(Yazar yazar) {
		Yazar kaydedilenYazar = null;
		Transaction tx = null;
		try {
			Session session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			kaydedilenYazar = session.merge(yazar);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return kaydedilenYazar;
	}
}
