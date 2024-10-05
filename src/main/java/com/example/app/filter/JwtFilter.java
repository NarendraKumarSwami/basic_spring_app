package com.example.app.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.app.jwt.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	public JwtService jwtService;
	
	
	
	@Autowired
	public UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		 String authHeader =    request.getHeader("Authorization");
		
//                Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY5NDA4Mzc4OCwiZXhwIjoxNjk0MDg1NTg4fQ.XbvPGEiHu59wBHLlVO_KH8jYb5o1Tdv-AKnPovDa-Mg
	       String token = null;
	       String username= null;
	       String newToken = null;
	       System.out.println(authHeader);
	     if(authHeader != null && authHeader.contains("Bearer ")) {
	    	    token =  authHeader.substring(7);
	    	     username =      jwtService.extractUserName(token);
	    	     
	     }
	     
	     // authentication
	     if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	    	 
	    	       UserDetails userDetails =   userDetailsService.loadUserByUsername(username);
	    	       
	    	       System.out.println("Authenitcation is called"+ userDetails.getUsername());
	    	       if(jwtService.validateToken(token, userDetails)) {
	    	    	      UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	    	                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	    	                SecurityContextHolder.getContext().setAuthentication(auth);
	    	                
	    	                // create a new token according next time period
	    			    newToken =    jwtService.generateToken(username);
	    	       }
	     }
	     
	    if(newToken != null) {
	    	 response.setHeader("Authorization", "Bearer " +newToken);
	    }
	     
	    filterChain.doFilter(request, response);
		
	}

}
