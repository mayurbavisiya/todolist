package com.geeks.todo.controller;

import com.geeks.todo.beans.*;
import com.geeks.todo.repository.TaskRepository;
import com.geeks.todo.repository.UserProjectRepository;
import com.geeks.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProjectRepository userProjectRepository;

    @PostMapping
    public ResponseEntity createProject(@RequestBody Task project){
        if(project.getTitle() == null){
            return new ResponseEntity("Project Title is Empty", HttpStatus.BAD_REQUEST);
        }
        if(project.getDescription() == null){
            return new ResponseEntity("Project Description is Empty", HttpStatus.BAD_REQUEST);
        }
        project.setStatus(Status.Pending);
        return ResponseEntity.ok(projectRepository.save(project));
    }

    @PutMapping
    public ResponseEntity updateProject(@RequestBody Task project){
        if(project.getId() == null){
            return new ResponseEntity("Project Id is Null", HttpStatus.BAD_REQUEST);
        }
        if(!projectRepository.existsById(project.getId())){
            return new ResponseEntity("Project Not Exists", HttpStatus.BAD_REQUEST);
        }
        Task project1 = projectRepository.getOne(project.getId());
        if(project1.getTitle() != null){
            project1.setTitle(project.getTitle());
        }
        if(project1.getDescription() != null){
            project1.setDescription(project.getDescription());
        }
        return ResponseEntity.ok(projectRepository.save(project1));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteProject(@PathVariable Integer id){
        if(!projectRepository.existsById(id)){
            return new ResponseEntity("Project Not Exists", HttpStatus.BAD_REQUEST);
        }
        projectRepository.deleteById(id);
        return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getProject(@PathVariable Integer id){
        if(!projectRepository.existsById(id)){
            return new ResponseEntity("Project Not Exists", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(projectRepository.getOne(id));
    }

    @GetMapping
    public ResponseEntity getAllProjects(){
        return ResponseEntity.ok(projectRepository.findAll());
    }

    @PostMapping("/assign")
    public ResponseEntity assignProject(@RequestBody UserTask assignProject){
        if(assignProject.getTaskId() == null){
            return new ResponseEntity("Project Id is Null", HttpStatus.BAD_REQUEST);
        }
        if(assignProject.getUserId() == null){
            return new ResponseEntity("User Id is Null", HttpStatus.BAD_REQUEST);
        }
        if(!userRepository.existsById(assignProject.getUserId())){
            return new ResponseEntity("User Not Found", HttpStatus.BAD_REQUEST);
        }
        if(!projectRepository.existsById(assignProject.getTaskId())){
            return new ResponseEntity("Project Not Found", HttpStatus.BAD_REQUEST);
        }
        assignProject.setUsers(userRepository.getOne(assignProject.getUserId()));
        assignProject.setTask(projectRepository.getOne(assignProject.getTaskId()));
        assignProject.setStartDate(new Date());

        return ResponseEntity.ok(userProjectRepository.save(assignProject));
    }

    @GetMapping("/assign")
    public ResponseEntity getAssignedTasks(){
        List<AssignedTasks> list = new ArrayList<>();
        userProjectRepository.findAll().forEach(i->{
            AssignedTasks a = new AssignedTasks();
            a.setUser(i.getUsers().getFullName());
            a.setId(i.getTask().getId());
            a.setTitle(i.getTask().getTitle());
            a.setDescription(i.getTask().getDescription());
            a.setStartDate(i.getStartDate().toString());

            list.add(a);
        });
        return ResponseEntity.ok(list);
    }

    @GetMapping("/complete/{id}")
    public ResponseEntity completedProject(@PathVariable Integer id){
        if(!projectRepository.existsById(id)){
            return new ResponseEntity("Project Not Found", HttpStatus.BAD_REQUEST);
        }
        Task task = projectRepository.getOne(id);
        task.setStatus(Status.Complete);
        return ResponseEntity.ok(projectRepository.save(task));
    }

    @GetMapping("/user")
    public ResponseEntity getUserProjects(@PathVariable Integer id){
        if(!userRepository.existsById(id)){
            return new ResponseEntity("User Not Found", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userProjectRepository.findByUsers(userRepository.getOne(id)));
    }





}
