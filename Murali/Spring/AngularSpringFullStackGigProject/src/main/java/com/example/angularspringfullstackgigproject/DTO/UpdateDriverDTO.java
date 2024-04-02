package com.example.angularspringfullstackgigproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UpdateDriverDTO {
    private Long id;
    private String driverName;
    private String driverEmail;
    private String password;
    private String phoneNo;
    private String imageUrl;
}
