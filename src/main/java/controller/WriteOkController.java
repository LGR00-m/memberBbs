package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.sql.SQLException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspWriter;
import model.Dao;
import model.Dto;
import util.JWTokens;

@WebServlet("/room/makeok")
public class WriteOkController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("WriteOkController 들어옴");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		Map<String,Object> payloads= JWTokens.getTokenPayloads(JWTokens.getTokenInCookie(req, req.getServletContext().getInitParameter("TOKEN-NAME")));
		
		System.out.println("payloads: "+payloads);
		
		String username = payloads.get("sub").toString();
		System.out.println("WriteOkController 의 username: "+username);
		
		Dto item = new Dto();
		item.setTitle(title);
		item.setContent(content);
		item.setUsername(username);
		
		Dao dao = new Dao(getServletContext());		
		int affected=0;

        try {
            affected = dao.insert(item);
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            dao.close(); // 안전하게 리소스를 닫음
        }
        
		if(affected==1) {
			resp.sendRedirect(req.getContextPath()+"/room/indexs");
			return;
		}
		else{
			
			PrintWriter out = resp.getWriter();
			
			out.println("<script>");
			out.println("alert('입력 실패했어요');");
			out.println("history.back();");
			out.println("</script>");
			return;
		}

		
	}
}
