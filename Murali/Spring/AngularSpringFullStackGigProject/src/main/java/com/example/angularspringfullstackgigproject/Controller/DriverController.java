package com.example.angularspringfullstackgigproject.Controller;

import com.example.angularspringfullstackgigproject.DTO.DriverDTO;
import com.example.angularspringfullstackgigproject.DTO.DriverResponseDTO;
import com.example.angularspringfullstackgigproject.DTO.LoginDTO;
import com.example.angularspringfullstackgigproject.DTO.UpdateDriverDTO;
import com.example.angularspringfullstackgigproject.Model.DriverModel;
import com.example.angularspringfullstackgigproject.Repository.DriverRepository;
import com.example.angularspringfullstackgigproject.Service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/driver")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/login")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private DriverRepository driverRepository;

//    @GetMapping("/getAllDrivers")
//    public ResponseEntity<String> getAllDrivers(){
//        List<DriverModel> driverList = driverService.getAllDrivers();
//
//        if(driverList.isEmpty()){
//            return ResponseEntity.ok("No Drivers Found");
//        }else{
//            return ResponseEntity.ok(driverList.toString());
//        }
//    }

    @PostMapping ("/register")
    public ResponseEntity<String> registerDriver(@RequestBody DriverDTO dto){
        System.out.println("Register");
        return ResponseEntity.ok(driverService.registerDrive(dto));
    }

    @PostMapping("/login")
    public String driverLogin(@RequestBody LoginDTO loginDTO){
        System.out.println("Entered Login");
        return driverService.driverLogin(loginDTO);
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(){
        System.out.println("Entered Welcome");
        return ResponseEntity.ok("Hello Driver");
    }

    @GetMapping("/getAllDrivers")
    @ResponseBody
    public List<DriverResponseDTO> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @PostMapping ("/addDriver")
    public String addDriver(@RequestBody DriverDTO dto){

        driverService.addDriver(dto);


        return "ok";
    }

    @PutMapping("/updateDriver")
    public String updateDriver (@RequestBody UpdateDriverDTO dto) {
        System.out.println("Entered Update");
        System.out.println(dto.getDriverName());
        driverService.updateDriver(dto);
        return "ok";
    }


    @DeleteMapping("/deleteDriver/{id}")
    public String deleteDriver(@PathVariable("id") Long id){
        driverService.deleteDriver(id);
        return "ok";
    }
}
