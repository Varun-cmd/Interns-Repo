package com.example.demo.Controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequset {

    private String email;
    String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
