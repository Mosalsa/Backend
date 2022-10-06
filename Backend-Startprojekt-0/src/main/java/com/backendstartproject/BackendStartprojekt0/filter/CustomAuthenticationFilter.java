/**
 *
 *check
 *
 * */
package com.backendstartproject.BackendStartprojekt0.filter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;



public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    public static final Logger log= LoggerFactory.getLogger(CustomAuthenticationFilter.class);
    private final AuthenticationManager authenticationManager;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager=authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){

        String username= request.getParameter("username");
        String password= request.getParameter("password");
        log.info("username is:{}",username);  log.info("password is:{}",password);

        UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(username,password);

        return authenticationManager.authenticate(authenticationToken);

    }

    @Override //building an access token
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authentication) throws IOException {

        User user= (User)authentication.getPrincipal();  // User aus Userdetails nach erfolgreiche Aufruf der methode/attemptAuthentication/.

        Algorithm algorithm= Algorithm.HMAC256("secret".getBytes());     //secret ist das Geheimwort des Tokens und sollte vorher normallerweise verschlüsselt .in dem bespiel nicht. die wird in Application.property ordner angelegt.

        String access_token= JWT.create()                                             //kreiere Token die die username und Zeitstempel und die Rollesn vom User beinhaltet
                .withSubject(user.getUsername())                                      //Nutzername ist Teil de Tokens
                .withExpiresAt(new Date(System.currentTimeMillis()+100*60*1000))               //Gülltigkeitsdauer des Tokens. hier 100 Minute
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles",user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);

        String refresh_token=JWT.create()
                .withSubject(user.getUsername())//Nutzername ist Teil de Tokens
                .withExpiresAt(new Date(System.currentTimeMillis()+240*60*1000)) //Gülltigkeitsdauer des Tokens. hier 240 min
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);

        //response.setHeader("access-token",access-token);// für die ausgabe in x-www-form-urlencoded
        //response.setHeader("refresh-token",refresh-token);// für die ausgabe in x-www-form-urlencoded
        Map<String,String> tokens=new HashMap<>();// HashMap um json ausgabe des Responses
        tokens.put("access-token",access_token);
        tokens.put("refresh-token",refresh_token);

        response.setContentType(APPLICATION_JSON_VALUE);

        new ObjectMapper().writeValue(response.getOutputStream(),tokens);

    }

}
