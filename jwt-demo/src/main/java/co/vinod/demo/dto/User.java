package co.vinod.demo.dto;

import lombok.Data;

@Data
public class User {
	private String email;
	private String password; // md5 or bcrypt
}
