package model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dto {
	
	private long id;
	private String title;
	private String content;
	private Date postDate;
	private String username;
	private long hitcount;
	private UsersDto user;
	
}
