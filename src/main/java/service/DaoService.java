package service;

import java.util.List;
import java.util.Map;

// 제너릭 인터페이스
public interface DaoService<T> {
	
	void close();
	List<T> findAll(Map<String, String> map);
	T findbyId(String ... params);
	int getTotalResourceCount(Map<String, String> map);
	int insert(T dto);
	int update(T dto);
	int delete(T dto);
	int getTotalRecordCount(Map<String, String> map);
	
}
