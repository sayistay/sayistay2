package tr.gov.sayistay.servlet;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tr.gov.sayistay.business.YazarBusiness;
import tr.gov.sayistay.entity.Yazar;

@WebServlet("/")
public class YazarServlet extends HttpServlet {
	private static final long serialVersionUID = -284379748519304334L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("yazarListesi", new YazarBusiness().getYazarlar());
		req.getRequestDispatcher("/yazarlar.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Yazar yazar = new Yazar();
		yazar.setAdi(req.getParameter("adi"));
		yazar.setSoyadi(req.getParameter("soyadi"));
		yazar.setDogumTarihi(LocalDate.parse(req.getParameter("dtarihi")));
		YazarBusiness yazarBusiness = new YazarBusiness();
		yazarBusiness.yazarKaydet(yazar);

		req.setAttribute("mesaj", "Yazar oluşturulmuştur");
		req.setAttribute("yazarListesi", yazarBusiness.getYazarlar());
		req.getRequestDispatcher("/yazarlar.jsp").forward(req, resp);

	}

}
