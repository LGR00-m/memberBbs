package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dao;
import model.Dto;

@WebServlet("/room/updateOk")
public class UpdateController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("목록으로 가기 위한 서블릿으로 들어옴");
		//req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
	    String content = req.getParameter("content");
	    System.out.println("title,content: "+title+content);
	    
	    Dto dto = new Dto();
        dto.setTitle(title);
        dto.setContent(content);
        
        Dao dao = new Dao(getServletContext());
        int affected = dao.update(dto);
        dao.close();
	    
        if (affected == 1) {
            resp.sendRedirect(req.getContextPath() + "/WEB-INF/room/View.jsp");
        } else {
            // 등록 실패 시 처리
            resp.getWriter().println("등록에 실패했습니다.");
        }  
	}
}
