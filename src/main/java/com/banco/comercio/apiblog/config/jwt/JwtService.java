package com.banco.comercio.apiblog.config.jwt;

import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.security.Key;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;


@Service
public class JwtService {


    private static final Logger LOG = LoggerFactory.getLogger(JwtService.class);
    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiration.seconds}")
    private Long expirationSeconds;

    @Value("${jwt.secretKey}")
    private String secretKey;


    public String generateJwtToken(UserEntity user) {
        Assert.notNull(user, "user can not be null");

        final AbstractMap.SimpleImmutableEntry<String, Object> userRoles =
                new AbstractMap.SimpleImmutableEntry<>("roles", user.getRoles());

        Map<String, Object> claims = new HashMap<>();
        claims.put(userRoles.getKey(), userRoles.getValue());
        claims.put("alg","RS256");
        claims.put("typ","JWT");

        return generateJwtToken(user,claims);
    }

    public String generateJwtToken(UserEntity user, Map<String,Object> claims){
        Assert.notNull(user, "user can not be null");

        Instant now = Instant.now();

        return Jwts
                .builder()
                .setSubject(user.getUsername())
                .setIssuer(issuer)
                .setIssuedAt(Date.from(now))
                .setId(UUID.randomUUID().toString())
                .setExpiration(Date.from(now.plusSeconds(expirationSeconds)))
                .addClaims(claims)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {

        return extractClaims(token, Claims::getSubject);
    }

    public <T> T extractClaims(String token, Function<Claims,T> claimsResolver) {
        final Claims claims = parseClaims(token);
        return claimsResolver.apply(claims);
    }
    private JwtParser jwtParser() {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey()).build();
    }
    public Claims parseClaims(String token) {
        try {
            return jwtParser().parseClaimsJws(token).getBody();
        } catch (SignatureException e) {
            LOG.error("Invalid JWT signature: {}", e.getMessage());
            //throw new BadTokenException("Invalid JWT signature ", HttpStatus.BAD_REQUEST);
        }

        return Jwts.claims();
    }
    private Key getSignInKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
