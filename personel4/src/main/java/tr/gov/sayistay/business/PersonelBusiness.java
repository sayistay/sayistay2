package tr.gov.sayistay.business;

import java.util.List;

import tr.gov.sayistay.dao.PersonelDAO;
import tr.gov.sayistay.entity.Personel;

public class PersonelBusiness {
	public List<Personel> getPersoneller() {
		return new PersonelDAO().getPersoneller();
	}
}
