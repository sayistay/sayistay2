package tr.gov.sayistay.business;

import java.util.List;

import tr.gov.sayistay.dao.YazarDAO;
import tr.gov.sayistay.entity.Yazar;

public class YazarBusiness {
	public List<Yazar> getYazarlar() {
		return new YazarDAO().getYazarlar();
	}

	public Yazar yazarKaydet(Yazar yazar) {
		return new YazarDAO().kaydet(yazar);
	}
}
