package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Job;
import com.example.demo.Models.User;
import com.example.demo.Repository.JobRepository;
import com.example.demo.Repository.UserRepository;

@RestController
@RequestMapping("api/job")
public class JobController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	@PostMapping("/createJob/{id}")
	public String createJob(@PathVariable("id") int userId, @RequestBody Job job) {
		
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isPresent()) {
			User existingUser = user.get();
			
			job.setUser(existingUser);
			jobRepository.save(job);
			
			return "Job Created Successfully";
		}else {
			return "User Not Found :(";
		}
		
	}
}
