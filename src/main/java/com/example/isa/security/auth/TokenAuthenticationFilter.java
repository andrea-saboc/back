package com.example.isa.security.auth;


import com.example.isa.security.TokenUtils;
import com.example.isa.security.auth.TokenBasedAuthentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private TokenUtils tokenUtils;
    private UserDetailsService userDetailsService;

    public TokenAuthenticationFilter(TokenUtils tokenHelper, UserDetailsService userDetailsService) {
        this.tokenUtils = tokenHelper;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	
    	System.out.println("Usao u filter internal");
        String username;
        String authToken = tokenUtils.getToken(request);

        if (authToken != null) {
            username = tokenUtils.getUsernameFromToken(authToken);

            if (username != null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                	
                System.out.println("Treba da se validira token ");
                if (tokenUtils.validateToken(authToken, userDetails)) {
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                    System.out.println("Sta je auth .. "+authentication == null);
                    
                    authentication.setToken(authToken);
                    System.out.println("Postavljanje contexta..");
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    
                }
            }
        }

        chain.doFilter(request, response);
    }

}
