package tr.gov.sayistay.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tr.gov.sayistay.business.KitapBusiness;
import tr.gov.sayistay.business.YazarBusiness;

@WebServlet("/kitaplar")
public class KitapServlet extends HttpServlet {
	private static final long serialVersionUID = -2345253244304334L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int yazarId = Integer.valueOf(req.getParameter("id"));
		req.setAttribute("yazar", new YazarBusiness().getYazar(yazarId));
		req.setAttribute("kitapListesi", new KitapBusiness().getKitaplar(yazarId));
		req.getRequestDispatcher("/kitaplar.jsp").forward(req, resp);
	}

}
