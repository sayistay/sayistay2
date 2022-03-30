package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import bean.Personel;
import business.PersonelBusiness;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class PersonelServlet extends HttpServlet {
	private static final long serialVersionUID = 5999710141201379506L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Personel> personeller = new PersonelBusiness().getPersoneller();
		PrintWriter out = resp.getWriter();
		personeller.forEach(out::println);
	}
}
