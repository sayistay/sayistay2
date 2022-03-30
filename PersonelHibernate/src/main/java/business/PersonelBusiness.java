package business;

import java.util.List;

import bean.Personel;
import dao.PersonelDAO;

public class PersonelBusiness {
	public List<Personel> getPersoneller() {
		return new PersonelDAO().getPersoneller();
	}
}
