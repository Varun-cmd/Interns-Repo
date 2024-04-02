package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class WebController {
	
	@RequestMapping(value = "path/{id}", method = RequestMethod.GET)
	public int returnId(@PathVariable("id") int id) {
		return id;
	}
	
	@RequestMapping(value = "requestparam", method = RequestMethod.POST)
	public String returnId(@RequestParam(defaultValue="123") String id, @RequestParam(defaultValue="murali") String Myname ) {
		return id +" "+Myname;
	}
	
	@PostMapping("/requestBody")
	public ResponseEntity<HttpStatus> postController(@RequestBody LoginForm loginForm){
		

		
		if(loginForm.getPassword()==null || loginForm.getUsername()==null) {
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
		}
		
		
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("responseBody/{id}")
	public LoginForm getUserById(@PathVariable int id) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		LoginForm l = (LoginForm) context.getBean("loginForm");
		return l;
	
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex) {
		return "Exception";
	}
	
}
