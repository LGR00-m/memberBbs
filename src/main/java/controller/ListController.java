package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dao;
import model.Dto;
import util.PagingUtil;


//1]사용자 요청을 받을 수 있도록 서블릿 클래스로 만들기(HttpServlet상속)즉 컨트롤러로 만들기
@WebServlet(urlPatterns = "/room/indexs",initParams = {@WebInitParam(name = "PAGE-SIZE",value = "2"),@WebInitParam(name = "BLOCK-PAGE",value = "2")})
public class ListController extends HttpServlet {
	
	//회원가입 완료 후 이동
	/*
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		req.getRequestDispatcher("/WEB-INF/room/Lists.jsp").forward(req, resp);

	}
	*/

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//가]사용자 요청을 받는다	
		//나]요청을 분석한다.
		//다]모델에서 필요한 로직 호출해서 결과값이 있으면 받기
		Dao dao = new Dao(getServletContext());
		Map<String,String> map = new HashMap<>();
		//먼저 단,PAGE_SIZE 및 BLOCK_PAGE는 맵에 설정해야 한다
		String pageSize= getInitParameter("PAGE-SIZE");
		String blockPage= getInitParameter("BLOCK-PAGE");
		map.put(PagingUtil.PAGE_SIZE,pageSize);
		map.put(PagingUtil.BLOCK_PAGE,blockPage);
		//아래 메소드 호출시 페이징과 관련된 값들이 맵에 설정되 있다
		PagingUtil.setMapForPaging(map, dao, req);
		
		
		//목록 관련 로직 호출
		List<Dto> records= dao.findAll(map);
		dao.close();
		//페이징 관련 로직 호출
		int totalRecordCount=Integer.parseInt(map.get(PagingUtil.TOTAL_RECORD_COUNT));
		int nowPage=Integer.parseInt(map.get(PagingUtil.NOWPAGE));
		
		String paging=PagingUtil.pagingBootStrapStyle(
				totalRecordCount,
				Integer.parseInt(pageSize),
				Integer.parseInt(blockPage),
				nowPage,
				req.getContextPath()+"/room/list?");
		
		//라]결과값이 있으면 리퀘스트 영역에 저장
		req.setAttribute("records", records);
		req.setAttribute("paging", paging);
		System.out.println("List컨트롤러에서 저장완료");
		//마]결과값을 뿌려줄 뷰(JSP페이지) 선택후 포워딩 
		//뷰선택]
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/room/Lists.jsp");
		//포워딩]		
		dispatcher.forward(req, resp);
	}
}
