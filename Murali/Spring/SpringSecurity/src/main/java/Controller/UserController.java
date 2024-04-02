package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.User;
import Services.UserServices;

@RestController

public class UserController {
	

	@Autowired
	private UserServices userService;
	

	
	@GetMapping("/error")
	public String error() {
		return "rpprp";
	}
	
	@PostMapping("/createUser")
	public String createUser(@RequestBody User user) {	
		userService.createUser(user);
		return "User Successfully Created"; 
	}
	

}
