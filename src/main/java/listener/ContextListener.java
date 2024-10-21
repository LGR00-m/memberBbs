package listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener{
	
	public ContextListener() {
		System.out.println("MyContextListener의 생성자: Pre-loading");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// context가 종료될 때 자동 실행됨
		System.out.println("웹 어플리케이션이 종료 되었습니다");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// context가 생성될 때 자동 실행됨
		// 여기서 getServletContext 는 jsp의 내장객체인 application와 같음.
		System.out.println("웹 어플리케이션이 시작 되었습니다");
		System.out.println("서버 정보:"+sce.getServletContext().getServerInfo());
		System.out.println("컨텍스트 루트:"+sce.getServletContext().getContextPath());
		
		// 데이타 소스를 어플리케이션 영역에 저장 - 인자 sce를 활용하여 어플리케이션 객체 호출 및 파라미터로 데이타 소스 가져오기
		try {
			// 1] 데이타 소스 가져오기 - 커넥션 풀
			Context ctx = new InitialContext();
			DataSource source = (DataSource)ctx.lookup(sce.getServletContext().getInitParameter("JNDI-ROOT")+"/ict");
			System.out.println("source:" +source);
			// 2] 어플리케이션 영역에 저장
			sce.getServletContext().setAttribute("DATA-SOURCE", source);
		}
		catch (NamingException e) {e.printStackTrace();}
		
	}
	

}
