package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspWriter;
import util.JWTokens;

@WebServlet("/room/outroom")
public class LogOutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 로그아웃 요청 (쿠키 삭제)
		Cookie cookie = new Cookie(req.getServletContext().getInitParameter("TOKEN-NAME"), "");
		cookie.setPath(req.getContextPath());
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		System.out.println("LogOutController 들어옴");
		
	
		
		// 로그인 페이지로 이동]
		resp.sendRedirect(req.getContextPath()+"/room/indexs");
	}
}
