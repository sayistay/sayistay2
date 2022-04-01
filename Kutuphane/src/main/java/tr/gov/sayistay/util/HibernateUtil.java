package tr.gov.sayistay.util;

import java.time.LocalDate;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tr.gov.sayistay.dao.KitapDAO;
import tr.gov.sayistay.dao.YazarDAO;
import tr.gov.sayistay.entity.Kitap;
import tr.gov.sayistay.entity.Yazar;

public class HibernateUtil {
	private static SessionFactory factory;
	private static ThreadLocal<Session> session = new ThreadLocal<Session>();

	private static SessionFactory getSessionFactory() {
		if (factory == null) {
			factory = new Configuration().configure().buildSessionFactory();
			databaseInit();
		}
		return factory;
	}

	private static void databaseInit() {
		yazarInit();
		kitapInit();
	}

	private static void yazarInit() {
		YazarDAO yazarDAO = new YazarDAO();
		if (yazarDAO.getYazarSayisi() == 0) {
			// @formatter:off
			Arrays.asList(
					new Yazar(0, "Jules", "Verne", LocalDate.of(1900, 12, 30), null),
					new Yazar(0, "Mikhail", "Bulgakov", LocalDate.of(1923, 7, 14), null),
					new Yazar(0, "Ömer", "Seyfettin", LocalDate.of(1926, 4, 15), null),
					new Yazar(0, "Sabahattin", "Ali", LocalDate.of(1943, 7, 23), null),
					new Yazar(0, "Kemal", "Tahir", LocalDate.of(1911, 3, 5), null))
					.forEach(yazarDAO::yazarOlustur);
			// @formatter:on
		}
	}

	private static void kitapInit() {
		KitapDAO kitapDAO = new KitapDAO();
		YazarDAO yazarDAO = new YazarDAO();
		if (kitapDAO.getKitapSayisi() == 0) {
			// @formatter:off
			Arrays.asList(
					new Kitap(0, "Dünyanın merkezine seyahat", 386, yazarDAO.getYazar("Jules","Verne")),
					new Kitap(0, "Aya seyahat", 207, yazarDAO.getYazar("Jules","Verne")),
					new Kitap(0, "Usta ve Margarita", 835, yazarDAO.getYazar("Mikhail","Bulgakov")),
					new Kitap(0, "Kaşağı", 115, yazarDAO.getYazar("Ömer","Seyfettin")),
					new Kitap(0, "Kürk Mantolu Madonna", 462, yazarDAO.getYazar("Sabahattin","Ali")),
					new Kitap(0, "Yorgun Savaşçı", 338, yazarDAO.getYazar("Kemal","Tahir"))
					).forEach(kitapDAO::kitapOlustur);
			// @formatter:on
		}

	}

	public static Session getSession() {
		Session session = HibernateUtil.session.get();
		if (session == null) {
			session = getSessionFactory().openSession();
			HibernateUtil.session.set(session);
		}
		return session;
	}

	public static void closeSession() {
		Session session = HibernateUtil.session.get();
		if (session != null && session.isOpen()) {
			session.close();
			HibernateUtil.session.remove();
		}
	}

	public static void main(String[] args) {
		getSession();
	}
}
