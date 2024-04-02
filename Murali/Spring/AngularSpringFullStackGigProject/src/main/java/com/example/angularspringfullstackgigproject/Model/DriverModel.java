package com.example.angularspringfullstackgigproject.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "driver")
public class DriverModel implements Serializable, UserDetails {

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long Id;

    @Column()
    private String driverName;
    @Column(unique = true)
    private String driverEmail;
    @Column
    private String password;
    @Column
    private String phoneNo;
    @Column(unique = true)
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String driverCode;


    @Enumerated(EnumType.STRING)
    private Role role;

//    public DriverModel(String driverName, String driverEmail, String password, String phoneNo, String imageUrl) {
//        this.driverName = driverName;
//        this.driverEmail = driverEmail;
//        this.password = password;
//        this.phoneNo = phoneNo;
//        this.imageUrl = imageUrl;
//        this.driverCode = String.valueOf(UUID.randomUUID());
//    }
//
//    public DriverModel() {
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return driverEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverEmail() {
        return driverEmail;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setDriverEmail(String driverEmail) {
        this.driverEmail = driverEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }




}
