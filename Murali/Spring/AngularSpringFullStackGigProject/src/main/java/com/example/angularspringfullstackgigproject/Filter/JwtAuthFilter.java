package com.example.angularspringfullstackgigproject.Filter;

import com.example.angularspringfullstackgigproject.Service.DriverService;
import com.example.angularspringfullstackgigproject.Service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

   @Autowired
    private JwtService jwtService;




    @Override
    protected void doFilterInternal(
            @NonNull  HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String jwtToken;
        final String userEmail;
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        jwtToken = authHeader.substring(7);
        userEmail = jwtService.getUserEmail(jwtToken);
        System.out.println(userEmail);

        if(userEmail!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            System.out.println("Entered Auth Process");

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            System.out.println(userDetails.getUsername()+" "+userDetails.getPassword());
            if(jwtService.isTokenValid(jwtToken, userDetails)){
                System.out.println("Has Valid Token");
                UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                System.out.println("Auth token creatded" + authtoken);

                authtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                System.out.println("Details Set");
//                authtoken.setAuthenticated(true);
                SecurityContextHolder.getContext().setAuthentication(authtoken);
                System.out.println("Context Set");
                System.out.println(SecurityContextHolder.getContext().getAuthentication());

            }
        }
        filterChain.doFilter(request,response);
    }
}
