package tr.gov.sayistay.business;

import java.util.List;

import tr.gov.sayistay.dao.KitapDAO;
import tr.gov.sayistay.entity.Kitap;

public class KitapBusiness {
	public List<Kitap> getKitaplar(int yazarId) {
		return new KitapDAO().getKitaplar(yazarId);
	}
}
