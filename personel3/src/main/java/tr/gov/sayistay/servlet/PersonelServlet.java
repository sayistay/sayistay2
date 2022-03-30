package tr.gov.sayistay.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tr.gov.sayistay.business.PersonelBusiness;
import tr.gov.sayistay.entity.Personel;

@WebServlet("/")
public class PersonelServlet extends HttpServlet {
	private static final long serialVersionUID = 5999710141201379506L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Personel> personeller = new PersonelBusiness().getPersoneller();
		req.setAttribute("liste", personeller);
		req.getRequestDispatcher("/personelListesi.jsp").forward(req, resp);
	}
}
