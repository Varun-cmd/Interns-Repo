package com.example.demo.Controller;

import com.example.demo.Service.AuthService;
import com.example.demo.Service.JwtService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final AuthService authService;

    @Autowired
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequset request){
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return ResponseEntity.ok(authService.reister(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse>authenticate(@RequestBody AuthenticationRequset request){

        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(HttpServletRequest  request){
        System.out.println("Entered Welcome");
        return ResponseEntity.ok("Hello "+authService.welcome(request));
    }
}
