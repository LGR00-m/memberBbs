package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import jakarta.servlet.ServletContext;
import service.DaoService;

public class UsersDao implements DaoService<UsersDto>{

	private Connection conn;
	private ResultSet rs;
	private PreparedStatement psmt;
	
	// 1] 커넥션 풀- 리스터에서 컨텍스트 영역에 저장된 데이타 소스 가져오기
	public UsersDao(ServletContext context) {
		System.out.println("ServletContext 영역");
		DataSource source = (DataSource)context.getAttribute("DATA-SOURCE");
		try {
			conn= source.getConnection();
		} catch (SQLException e) {e.printStackTrace();}		
	}
	
	// 2] 자원 반납용
	@Override
	public void close() {
		try {
			psmt.close();
			rs.close();
			conn.close();		
		} catch(SQLException e) { e.printStackTrace();}
		
	}

	@Override
	public List<UsersDto> findAll(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsersDto findbyId(String... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalResourceCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(UsersDto dto) {

		int affected=0;
		try {
			psmt = conn.prepareStatement("INSERT INTO users VALUES(?,?,?,DEFAULT,?,?,?)");
			psmt.setString(1, dto.getUsername());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getPassword());
			psmt.setString(4, dto.getGender());
			psmt.setString(5, String.join(",", dto.getInter()));
			psmt.setString(6, dto.getGrade());
			
			
			
			affected=psmt.executeUpdate();
			
		}
		catch(SQLException e) {e.printStackTrace();}
		return affected;
	}
	@Override
	public int update(UsersDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UsersDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public int getTotalRecordCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	// 회원 여부 판단용
	public boolean isUser(String username, String password) {
		try {
			psmt= conn.prepareStatement("SELECT COUNT(*) FROM users WHERE username=? AND password=?");
			psmt.setString(1, username);
			psmt.setString(2, password);
			rs= psmt.executeQuery();
			rs.next();
			if(rs.getInt(1)==0) return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;		
	}
	


	
	
	
	
	
}
