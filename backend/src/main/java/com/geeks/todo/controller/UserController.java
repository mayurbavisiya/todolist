package com.geeks.todo.controller;


import com.geeks.todo.beans.User;
import com.geeks.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity addUser(@RequestBody User user){
        if(user.getAddress() == null){
            return new ResponseEntity("Address is Null", HttpStatus.BAD_REQUEST);
        }
        if(user.getEmail() == null){
            return new ResponseEntity("Email is Null", HttpStatus.BAD_REQUEST);
        }
        if(user.getFullName() == null){
            return new ResponseEntity("Full Name is Null", HttpStatus.BAD_REQUEST);
        }
        if(user.getUsername() == null){
            return new ResponseEntity("Username is Null", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody User user){
        if(user.getId() == null){
            return new ResponseEntity("User Not Found", HttpStatus.BAD_REQUEST);
        }
        else if(!userRepository.existsById(user.getId())){
            return new ResponseEntity("User Not Found", HttpStatus.BAD_REQUEST);
        }
        User user1 = userRepository.getOne(user.getId());
        if(user.getAddress() != null){
            user1.setAddress(user.getAddress());
        }
        if(user.getEmail() != null){
            user1.setEmail(user.getEmail());
        }
        if(user.getFullName() != null){
            user1.setFullName(user.getFullName());
        }
        if(user.getUsername() != null){
            user1.setUsername(user.getUsername());
        }
        if(user.getPhone() != null){
            user1.setPhone(user.getPhone());
        }
        return ResponseEntity.ok(userRepository.save(user1));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        if(!userRepository.existsById(id)){
            return new ResponseEntity("User Not Found", HttpStatus.OK);
        }
        userRepository.deleteById(id);
        return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getUser(@PathVariable Integer id){
        if(!userRepository.existsById(id)){
            return new ResponseEntity("User Not Found", HttpStatus.OK);
        }
        return ResponseEntity.ok(userRepository.getOne(id));
    }

    @GetMapping
    public ResponseEntity getAllUser(){
        return ResponseEntity.ok(userRepository.findAll());
    }


}
