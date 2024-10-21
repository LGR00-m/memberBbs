package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dao;
import model.Dto;

@WebServlet("/room/moveView")
public class ViewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ViewController들어옴");
		String id = req.getParameter("id");
		
		Dao dao = new Dao(getServletContext());
		Dto dto= dao.findbyId(id);
		System.out.println("dto: "+dto);
		dao.close();
		
		if (dto != null) {
            dto.setContent(dto.getContent().replace("\r\n", "<br/>"));
            req.setAttribute("record", dto);
            System.out.println("ViewController - record 저장됨");
            System.out.println("ViewController의 dto: "+dto);
            System.out.println("ViewController의 dto.getTitle(): "+dto.getTitle());
        } else {
            System.out.println("No record found with ID: " + id);
        }
		req.getRequestDispatcher("/WEB-INF/room/View.jsp").forward(req, resp);
	}
}
