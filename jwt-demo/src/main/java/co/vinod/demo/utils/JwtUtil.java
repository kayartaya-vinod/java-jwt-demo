package co.vinod.demo.utils;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtUtil {

	private static String SECRET_KEY = "ZL8KN.k?kpyvCnKQ.f$eDh%e^NvBX.6yAVgNVB2aP:@b/<kz";

	public static String createToken(Integer userId, String fullname) throws Exception {
		try {
			Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
			return JWT.create()
					.withSubject(fullname)
					.withClaim("id", userId)
					.withIssuedAt(new Date())
					.withExpiresAt(new Date(System.currentTimeMillis() + 15 * 60 * 1000))
					.sign(algorithm);
			
		} catch (Exception ex) {
			throw ex;
		}
	}

	// this function returns the id of the user inside the encoded token, if
	// verified
	public static Integer verify(String token) throws Exception {
		Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
		JWTVerifier verifier = JWT.require(algorithm).build(); // Reusable verifier instance
		DecodedJWT jwt = verifier.verify(token);
		
		log.info("fullname = {}", jwt.getSubject());
		return jwt.getClaim("id").asInt();
	}
}
