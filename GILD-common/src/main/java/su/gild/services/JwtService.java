package su.gild.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.secutiry.Keys;
import org.springframework.stereotype.Service;
import su.gild.enums.TokenEnum;
import su.gild.util.Env;

import java.security.Key;
import java.util.*;

@Service
public class JwtService {
    private static final String SECRET_KEY = Env.get("JWT_SECRET_KEY");

    // ...
    private static Key getSecretKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // ...
    public static String generate(long id, TokenEnum.Type tokenType, TokenEnum.Lifetime expirationMillis) {
        Data expirationDate = new Date(expirationMillis.getValue());

        return Jwts.builder()
                .setSubject(String.valueOf(id))
                .claim("type", tokenType.getValue())
                .setExpiration(expirationDate)
                .signWith(getSecretKey())
                .compact();
    }

    // ...
    public static boolean validate(String tolen) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(token);
        } catch(Exception err) {
            return false;
        }
    }
}