package model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDto {
	private String username;
	private String password;
	private String name;
	private String gender;
	private String[] inter;
	private String grade;
	private LocalDateTime regiDate;
}
