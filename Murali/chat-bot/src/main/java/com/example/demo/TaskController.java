package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



//@RestController
//@RequestMapping("/api/tasks")
//@CrossOrigin(origins = "http://localhost:65483") 
//public class TaskController {
//
//    private static final Logger logger = (Logger) LoggerFactory.getLogger(TaskController.class);
//
//    @PostMapping
//    public void createTask(@RequestBody Task task) {
//        // Log the task information
//        logger.info("Task Name: {}", task.getTaskName());
//        logger.info("Task Description: {}", task.getTaskDescription());
//    }
//}





@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:64946") 
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestParam("file") MultipartFile file, Task task) {
    	try {
            System.out.println("Received File:");
            System.out.println("File Name: " + file.getOriginalFilename());
            System.out.println("File Size: " + file.getSize());

            System.out.println("Received Task:");
            System.out.println("Task Name: " + task.getTaskName());
            System.out.println("Task Description: " + task.getTaskDescription());
            System.out.println("Latitude: " + task.getLatitude());
            System.out.println("Longitude: " + task.getLongitude());
            
            byte[] fileContent = file.getBytes();
            task.setFileContent(fileContent);

            return taskRepository.save(task);
        } catch (Exception e) {
       
            e.printStackTrace();
            return null;
        }
    }
}