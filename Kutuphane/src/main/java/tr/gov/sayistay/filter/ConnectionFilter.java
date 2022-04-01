package tr.gov.sayistay.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tr.gov.sayistay.util.HibernateUtil;

@WebFilter("/*")
public class ConnectionFilter extends HttpFilter {
	private static final long serialVersionUID = 8350536801921278922L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
		HibernateUtil.closeSession();
	}
}
