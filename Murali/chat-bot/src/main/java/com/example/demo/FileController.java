package com.example.demo;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/file")
@CrossOrigin(origins = "http://localhost:61970") 
public class FileController {
	
	@PostMapping
	public String saveFile(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		return "file received successfully";
	}
}
