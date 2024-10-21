package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.sql.DataSource;

import jakarta.servlet.ServletContext;
import service.DaoService;

public class Dao implements DaoService<Dto>{
	
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement psmt;
	
	
	
	// 1] 커넥션 풀- 리스터에서 컨텍스트 영역에 저장된 데이타 소스 가져오기
	public Dao(ServletContext context) {
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
			if(rs !=null) rs.close();
			if(psmt !=null) psmt.close();
			if(conn !=null) conn.close();
		
		} catch(SQLException e) { e.printStackTrace();}
		
	}

	@Override
	public List<Dto> findAll(Map<String, String> map) {
		
		List<Dto> items=new Vector<>();
		String sql ="SELECT * FROM BBS";
		
		try {
		System.out.println("findAll 에는 들어옴");
			psmt= conn.prepareStatement(sql);
			rs= psmt.executeQuery();
			while(rs.next()) {
				Dto item = new Dto();
				item.setId(rs.getLong(1));
				item.setTitle(rs.getString(2));
				item.setContent(rs.getString(3));
				item.setPostDate(rs.getDate(4));
				item.setUsername(rs.getString(5));
				item.setHitcount(rs.getLong(6));

				items.add(item);
			}
		} catch (SQLException e) {e.printStackTrace();}
		return items;
	}
	
	@Override
	public Dto findbyId(String... params) {
		Dto item=null;

		try {

			//목록에서 넘어온 경우에만
			if(params.length >=2 && params[1].toUpperCase().startsWith("LIST")) {
				//조회수 증가
				psmt = conn.prepareStatement("UPDATE bbs SET hitcount= hitcount+1 WHERE id=?");
				psmt.setString(1, params[0]);
				psmt.executeUpdate();
			}
			
			
			
			//레코드 하나 조회
			psmt = conn.prepareStatement("SELECT b.*,name FROM bbs b JOIN users u ON b.username=u.username WHERE id=?");
			psmt.setString(1, params[0]);
			rs = psmt.executeQuery();
			if(rs.next()) {
				item = new Dto();
				item.setId(rs.getLong(1));
				item.setTitle(rs.getString(2));
				item.setContent(rs.getString(3));
				item.setPostDate(rs.getDate(4));
				item.setUsername(rs.getString(5));
				item.setHitcount(rs.getLong(6));
			
			}
		}
		catch(SQLException e) {e.printStackTrace();}
		return item;
	}

	@Override
	public int getTotalResourceCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Dto dto) {
		int affected=0;
		try {
			psmt = conn.prepareStatement("INSERT INTO BBS VALUES(SEQ_BBS.NEXTVAL,?,?,DEFAULT,?,DEFAULT)");
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getUsername());
			affected=psmt.executeUpdate();
			System.out.println("insert의 affected: "+affected);
			
		}
		catch(SQLException e) {e.printStackTrace();}
		return affected;
	}

	@Override
	public int update(Dto dto) {
		int affected=0;
		try {
			psmt = conn.prepareStatement("UPDATE bbs SET title=?,content=? WHERE id=?");
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setLong(3, dto.getId());
			affected=psmt.executeUpdate();
			
		}
		catch(SQLException e) {e.printStackTrace();}
		return affected;
	}

	@Override
	public int delete(Dto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalRecordCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
	
	
	
	
}
