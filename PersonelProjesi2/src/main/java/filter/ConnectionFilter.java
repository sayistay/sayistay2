package filter;

import java.io.IOException;

import db.DBBase;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

@WebFilter("/*")
public class ConnectionFilter extends HttpFilter {
	private static final long serialVersionUID = 893482900550928603L;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			chain.doFilter(request, response);
		} finally {
			DBBase.closeConnection();
		}
	}
}
