package cl.bci.creacion.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;


public class GenerateJWT {
	
	public String generarToken(String email, String name, String password) {
		
        Algorithm algorithm = Algorithm.HMAC512(email);

        String generatedToken = JWT.create()
                .withIssuer("Simple Solution")
                .withClaim("username", name)
                .withClaim("password", password)
                .sign(algorithm);

        System.out.println(generatedToken);
        
		return generatedToken;
		
	}
}
