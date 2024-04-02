package com.example.angularspringfullstackgigproject.Service;

import com.example.angularspringfullstackgigproject.DTO.DriverDTO;
import com.example.angularspringfullstackgigproject.DTO.DriverResponseDTO;
import com.example.angularspringfullstackgigproject.DTO.LoginDTO;
import com.example.angularspringfullstackgigproject.DTO.UpdateDriverDTO;
import com.example.angularspringfullstackgigproject.Model.DriverModel;
import com.example.angularspringfullstackgigproject.Model.Role;
import com.example.angularspringfullstackgigproject.Repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DriverService {

    @Autowired
    private DriverRepository driverRepo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;


    public String registerDrive(DriverDTO dto) {

        var driver = DriverModel.builder()
                .driverName(dto.getDriverName())
                .driverEmail(dto.getDriverEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .phoneNo(dto.getPhoneNo())
                .imageUrl(dto.getImageUrl())
                .driverCode(String.valueOf(UUID.randomUUID()))
                .role(Role.DRIVER)
                .build();

        driverRepo.save(driver);

        return jwtService.generateToken(driver);
    }

    public String driverLogin(LoginDTO loginDTO) {


            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getDriverEmail(), loginDTO.getPassword()
                    ));

        var driver = driverRepo.getDriverByDriverEmail(loginDTO.getDriverEmail())
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found"));

        return jwtService.generateToken(driver);
    }

    public List<DriverResponseDTO> getAllDrivers() {
        List<DriverModel> drivers = driverRepo.findAll();
        return drivers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private DriverResponseDTO convertToDto(DriverModel driverModel) {
        return modelMapper.map(driverModel, DriverResponseDTO.class);
    }

    public void addDriver(DriverDTO dto) {
        var driver = DriverModel.builder()
                .driverName(dto.getDriverName())
                .driverEmail(dto.getDriverEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .phoneNo(dto.getPhoneNo())
                .imageUrl(dto.getImageUrl())
                .driverCode(String.valueOf(UUID.randomUUID()))
                .role(Role.DRIVER)
                .build();
        driverRepo.save(driver);
    }

    public void updateDriver(UpdateDriverDTO dto) {
        Optional<DriverModel> optionalDriver = driverRepo.findById(dto.getId());

        if (optionalDriver.isPresent()) {
            DriverModel driver = optionalDriver.get();

            // Update fields if provided in the DTO
            if (dto.getDriverName() != null) {
                driver.setDriverName(dto.getDriverName());
            }
            if (dto.getDriverEmail() != null) {
                driver.setDriverEmail(dto.getDriverEmail());
            }
            if (dto.getPassword() != null) {
                driver.setPassword(dto.getPassword());
            }
            if (dto.getPhoneNo() != null) {
                driver.setPhoneNo(dto.getPhoneNo());
            }
            if (dto.getImageUrl() != null) {
                driver.setImageUrl(dto.getImageUrl());
            }

            // Save the updated driver
            driverRepo.save(driver);
        }
    }

    public void deleteDriver(Long id) {
        driverRepo.deleteById(id);
    }
}
