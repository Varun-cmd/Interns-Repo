package com.example.angularspringfullstackgigproject.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class DriverDTO {
    private String driverName;
    private String driverEmail;
    private String password;
    private String phoneNo;
    private String imageUrl;
}
