package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dao;
import model.UsersDao;
import util.JWTokens;

@WebServlet("/room/inroom")
public class LoginController extends HttpServlet{

	// 헤더에서 클릭 시
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginController get방식으로 들어옴");
		req.getRequestDispatcher("/WEB-INF/room/Login.jsp").forward(req, resp);
	}
	
	// 로그인 요청 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username= req.getParameter("username").trim();
		String password= req.getParameter("password").trim();
		
		System.out.println("username,password"+username+password);
		
		UsersDao dao = new UsersDao(getServletContext());
		boolean isUser= dao.isUser(username,password);
		dao.close();
		
		if(isUser) { // 회원이라면, 토큰 생성해서 쿠키로 전달
			Map<String, Object> payloads = new HashMap<>();
			payloads.put("username", username);
			
			long expirationTime = 1000*60*60*4;
			String token= JWTokens.createToken(username, payloads, expirationTime);
			
			Cookie cookie = new Cookie(req.getServletContext().getInitParameter("TOKEN-NAME"), token);
			cookie.setPath(req.getContextPath());
			cookie.setMaxAge((int)expirationTime/1000);
			resp.addCookie(cookie);
			
			Map<String,Object> claims= JWTokens.getTokenPayloads(token);
			req.setAttribute("claims", claims);
			
			req.getRequestDispatcher("/WEB-INF/room/LoginProcess.jsp").forward(req, resp);
			
		
		}
		else { // 비 회원이라면,
			req.setAttribute("errorMsg", "유효하지 않은 회원정보입니다.");
			req.getRequestDispatcher("/WEB-INF/room/Login.jsp").forward(req, resp);
			
		}
		
		
	}
	
}
