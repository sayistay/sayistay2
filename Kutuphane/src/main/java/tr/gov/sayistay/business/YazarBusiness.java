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

	public void yazarSil(long id) {
		YazarDAO yazarDAO = new YazarDAO();
		Yazar yazar = yazarDAO.getYazar(id);
		yazarDAO.sil(yazar);
	}

	public Yazar getYazar(long yazarId) {
		return new YazarDAO().getYazar(yazarId);
	}

}
