package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.JWTokens;

@WebFilter("/room/*")
public class AuthenticationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		String token=JWTokens.getTokenInCookie(request, req.getServletContext().getInitParameter("TOKEN-NAME"));
		boolean isAuthenticated=JWTokens.verifyToken(token);
		if(!isAuthenticated) {
			//request.setAttribute("errorMsg", "Please Use After Login...");
			response.sendRedirect(request.getContextPath()+"/room/inroom");
			return;
		}
		chain.doFilter(req, resp);
	}

}
