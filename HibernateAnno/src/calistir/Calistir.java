package calistir;

import java.util.List;

import entity.Personel;
import util.HibernateUtil;

public class Calistir {
	public static void main(String[] args) {
		List<Personel> personeller = HibernateUtil.getSession()
				.createQuery("from Personel", Personel.class).list();
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
	}
}
