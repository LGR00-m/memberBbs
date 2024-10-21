package controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dao;
import model.Dto;

@WebServlet("/room/edit")
public class EditController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("EditController 들어옴");
		String id =req.getParameter("id");
		
		Dao dao = new Dao(getServletContext());
		Dto dto = dao.findbyId(id);
		
		if (dto != null) {
		req.setAttribute("record", dto);
		req.getAttribute("record");

		req.getRequestDispatcher("/WEB-INF/room/Edit.jsp").forward(req, resp);
		}
		 else {
	   resp.getWriter().println("해당 게시글을 찾을 수 없습니다.");
		 }
	}
}
