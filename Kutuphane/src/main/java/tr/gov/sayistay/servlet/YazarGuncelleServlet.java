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

@WebServlet("/yazarGuncelle")
public class YazarGuncelleServlet extends HttpServlet {
	private static final long serialVersionUID = -28432343249304334L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		YazarBusiness yazarBusiness = new YazarBusiness();
		// sil ve güncelle işlemleri buraya geliyor.
		String seciliYazarId = req.getParameter("seciliYazar");
		// yazar seçilmeden gelindiyse
		if (seciliYazarId == null) {
			req.setAttribute("mesaj", "Yazar seçmediniz");
			req.setAttribute("yazarListesi", yazarBusiness.getYazarlar());
			req.getRequestDispatcher("/yazarlar.jsp").forward(req, resp);
		} else {
			long yazarId = Long.valueOf(seciliYazarId);
			if ("sil".equals(req.getParameter("islem"))) {
				// yazar sil
				yazarBusiness.yazarSil(yazarId);
				req.setAttribute("mesaj", "Yazar silinmiştir");
				req.setAttribute("yazarListesi", yazarBusiness.getYazarlar());
				req.getRequestDispatcher("/yazarlar.jsp").forward(req, resp);
			} else {
				// yazar güncelle
				req.setAttribute("yazar", yazarBusiness.getYazar(yazarId));
				req.getRequestDispatcher("/yazarGuncelle.jsp").forward(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Yazar yazar = new Yazar();
		yazar.setId(Integer.valueOf(req.getParameter("id")));
		yazar.setAdi(req.getParameter("adi"));
		yazar.setSoyadi(req.getParameter("soyadi"));
		yazar.setDogumTarihi(LocalDate.parse(req.getParameter("dtarihi")));
		YazarBusiness yazarBusiness = new YazarBusiness();

		yazarBusiness.yazarKaydet(yazar);

		req.setAttribute("mesaj", "Yazar güncellenmiştir");
		req.setAttribute("yazarListesi", yazarBusiness.getYazarlar());
		req.getRequestDispatcher("/yazarlar.jsp").forward(req, resp);
	}

}
