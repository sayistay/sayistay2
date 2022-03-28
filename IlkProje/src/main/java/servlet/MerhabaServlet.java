package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MerhabaServlet extends HttpServlet {
	private static final long serialVersionUID = -7740626101757378767L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Merhaba");
		PrintWriter out = resp.getWriter();
		out.println("Merhaba Dunya");
	}
}
