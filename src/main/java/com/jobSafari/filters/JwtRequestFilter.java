package com.jobSafari.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jobSafari.service.MyUserDetailService;
import com.jobSafari.util.JwtUtils;
@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private MyUserDetailService user;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authorizationHadder=request.getHeader("Authorization");
		String userName=null;
		String jwt=null;
		if(authorizationHadder !=null && authorizationHadder.startsWith("Bearer ")) {
			jwt=authorizationHadder.substring(7);
			userName=jwtUtils.getUsernameFromToken(jwt);
			
			if(userName !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails userDetails=this.user.loadUserByUsername(userName);
				if(jwtUtils.validateToken(jwt, userDetails));
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
