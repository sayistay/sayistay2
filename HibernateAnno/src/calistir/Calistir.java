package calistir;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Bolum;
import entity.Personel;
import util.HibernateUtil;

@SuppressWarnings("unused")
public class Calistir {
	public static void main(String[] args) {
		// test1();
		// test2();
		// test3();
		// test4();
		// test5();
		test6();
	}

	private static void test6() {
		// kayıt ekleme
		Session session = HibernateUtil.getSession();
		Personel personel = session.find(Personel.class, 10);
		System.out.println("Okunan personel :" + personel);
		// veritabanı değişikliklerinde transaction kullanmamız gerekiyor.
		// kayıt silmek için önce silinecek kayıdı okumamız gerekiyor.
		Transaction tx = session.beginTransaction();
		session.remove(personel);
		tx.commit();
		System.out.println("********* personel silme başarılı ******** ");
	}

	private static void test5() {
		// kayıt ekleme
		Session session = HibernateUtil.getSession();
		Personel p = new Personel();
		p.setAdi("Patalya");
		p.setSoyadi("Eftelya2");
		p.setId(2);

		// veritabanı değişikliklerinde transaction kullanmamız gerekiyor.
		Transaction tx = session.beginTransaction();
		p = session.merge(p);
		tx.commit();
		System.out.println("Güncellenen personel: " + p);
		System.out.println("********* güncelleme başarılı ******** ");
		Personel personel = session.find(Personel.class, 2);
		System.out.println(personel);

	}

	private static void test4() {
		// kayıt ekleme
		Session session = HibernateUtil.getSession();
		Personel p = new Personel();
		p.setAdi("Patalya");
		p.setSoyadi("Eftelya");
		p.setId(0);

		// veritabanı değişikliklerinde transaction kullanmamız gerekiyor.
		Transaction tx = session.beginTransaction();
		p = session.merge(p);
		tx.commit();
		System.out.println("Oluşturulan personel: " + p);
		System.out.println("********* ekleme başarılı ******** ");

	}

	private static void test3() {
		// kayıt güncelleme
		Session session = HibernateUtil.getSession();
		Personel p = session.find(Personel.class, 1);
		p.setAdi("Nurullah2");
		// veritabanı değişikliklerinde transaction kullanmamız gerekiyor.
		Transaction tx = session.beginTransaction();
		session.merge(p);
		tx.commit();

		System.out.println("********* güncelleme başarılı ******** ");
		Personel personel = HibernateUtil.getSession().find(Personel.class, 1);
		System.out.println(personel);
	}

	private static void test2() {
		List<Bolum> bolumler = HibernateUtil.getSession()
				.createQuery("from Bolum b join b.personeller p where p.adi = ?1", Bolum.class)
				.setParameter(1, "Murteza").list();
		bolumler.forEach(System.out::println);
		System.out.println("*********");
		long personelSayisi = HibernateUtil.getSession()
				.createQuery("select count(p) from Personel p", Long.class).getSingleResult();
		System.out.println("Personel sayisi:" + personelSayisi);
	}

	private static void test1() {
		List<Personel> personeller = HibernateUtil.getSession()
				.createQuery("from Personel p left join fetch p.bolum", Personel.class).list();
		personeller.forEach(System.out::println);
		System.out.println("*********");
		personeller.forEach(p -> System.out.println(p.getBolum()));
		System.out.println("************");
		personeller = HibernateUtil.getSession()
				.createQuery("from Personel p where p.bolum.adi = ?1", Personel.class)
				.setParameter(1, "Teknik Servis").list();
		personeller.forEach(System.out::println);
		System.out.println("************");
		Personel personel = HibernateUtil.getSession().find(Personel.class, 1);
		personel.getBolum().getPersoneller().forEach(System.out::println);
		System.out.println("************");
		Session session = HibernateUtil.getSession();
		Personel p1 = session.find(Personel.class, 1);
		System.out.println(p1);
		Personel p2 = session.find(Personel.class, 2);
		System.out.println(p2);
		// aynı session'da aynı primary key'li objeyi tekrar okumuyor. Cache'ten
		// veriyor.
		p1 = session.find(Personel.class, 1);
		System.out.println(p1);
	}
}
