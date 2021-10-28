package com.auctionapp.api.security;

import static io.jsonwebtoken.Jwts.parserBuilder;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtProvider extends UsernamePasswordAuthenticationFilter {

  public String generateToken(Authentication authentication) {
      org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
      return Jwts.builder()
              .setSubject(principal.getUsername())
              .setIssuedAt(new Date())
				      .setExpiration(new Date((new Date()).getTime() + SecurityConstants.EXPIRATION_TIME))
              .signWith(SecurityConstants.SECRET)
              .compact();
  }

  public boolean validateToken(String jwt) {
      parserBuilder().setSigningKey(SecurityConstants.SECRET).build().parseClaimsJws(jwt);
      return true;
  }

  public String getUsernameFromJwt(String token) {
      Claims claims = parserBuilder()
              .setSigningKey(SecurityConstants.SECRET)
              .build()
              .parseClaimsJws(token)
              .getBody();

      return claims.getSubject();
  }
}
