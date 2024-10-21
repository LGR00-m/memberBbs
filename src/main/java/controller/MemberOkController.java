package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;
import model.UsersDao;
import model.UsersDto;

@WebServlet("/room/inmemberOk")
public class MemberOkController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MemberOkController 들어옴");
		
		// 회원가입 정보 파라미터로 받기
		Map<String, String[]> map = req.getParameterMap();
		
		
		UsersDto dto = new UsersDto();
		
		dto.setName(map.get("name")[0]);
		dto.setUsername(map.get("username")[0]);
		dto.setPassword(map.get("password")[0]);
		dto.setGender(map.get("gender")[0]);
		dto.setInter(map.get("inter"));
		dto.setGrade(map.get("grade")[0]);
		
	
		UsersDao dao = new UsersDao(getServletContext());
		
		int affected= dao.insert(dto);
		
		if(affected == 1) {
			System.out.println("가입 성공");
			req.getRequestDispatcher("/WEB-INF/room/SignUpSucess.jsp").forward(req, resp);
		}
		else {
		System.out.println("가입 실패");
		resp.sendRedirect(req.getContextPath()+"/room/SignUp.jsp");
		}
	}
	
}
