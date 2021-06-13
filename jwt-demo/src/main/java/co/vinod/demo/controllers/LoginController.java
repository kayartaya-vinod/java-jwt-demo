package co.vinod.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.vinod.demo.dto.User;
import co.vinod.demo.utils.JwtUtil;

@CrossOrigin
@RestController
public class LoginController {

	@PostMapping("/api/login")
	public ResponseEntity<Object> login(@RequestBody User user) throws Exception {

		// make use of a DAO class to verify if the user's email and password are valid
		// temporary fix; hard coded email/password verification

		if (user.getEmail().equals("vinod@vinod.co") && user.getPassword().equals("topsecret")) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", 1234); // need to get this from DB using DAO
			map.put("fullname", "Vinod Kumar Kayartaya");
			map.put("token", JwtUtil.createToken(1234, "Vinod Kumar Kayartaya"));

			return ResponseEntity.ok(map);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email/password");
		}

	}

}
