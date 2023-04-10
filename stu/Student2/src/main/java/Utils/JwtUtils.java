package Utils;

import java.util.Calendar;
import java.util.HashMap;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;
public class JwtUtils {

	public static final String sale = "123456";

	public String getToken(String username) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("alg", "HMAC256");
		map.put("typ", "JWT");

		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.SECOND, 600);

		Builder builder = JWT.create();

		String token = builder.withHeader(map) // head
				.withClaim("username", username)// payload
				.withExpiresAt(instance.getTime()) // 过期时间 60秒之后
				.sign(Algorithm.HMAC256(sale));// 签名  盐
		return token;

	}

	public String getTokenUsername(String token) {
		// 创建验证对象
		Verification verification = JWT.require(Algorithm.HMAC256(sale));// 签名
		JWTVerifier jwtVerifier = verification.build();
		DecodedJWT verify;
		try {
			verify = jwtVerifier.verify(token);
			Claim username = verify.getClaim("username");
			return username.asString();
		} catch (JWTVerificationException e) {
			e.printStackTrace();
			throw e;
		}
	}

//	@Test
	public boolean getboolean(String token) {
		// 创建验证对象
		Verification verification = JWT.require(Algorithm.HMAC256(sale));// 签名
		JWTVerifier jwtVerifier = verification.build();

		DecodedJWT verify;
		try {
			verify = jwtVerifier.verify(token);
			return true;
		} catch (JWTVerificationException e) {
			return false;
		}
	}
}
