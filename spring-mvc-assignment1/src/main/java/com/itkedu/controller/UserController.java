package com.itkedu.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.itkedu.model.User;
import com.itkedu.service.UserService;
import com.itkedu.view.Views;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	  private final UserService userService;

	    public UserController(UserService userService){
	        this.userService = userService;
	    }
	    
	    @GetMapping
	    @JsonView(Views.UserSummary.class)
	    public List<User> getAllUsers(){
	        return userService.getAllUsers();
	    }

	    // Get user with orders

	    @GetMapping("/{id}")
	    @JsonView(Views.UserDetails.class)
	    public User getUser(@PathVariable Long id){
	        return userService.getUserById(id);
	    }

	    // Create user

	    @PostMapping
	    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
	        return ResponseEntity.ok(userService.createUser(user));
	    }

	    // Update user

	    @PutMapping("/{id}")
	    public ResponseEntity<User> updateUser(
	            @PathVariable Long id,
	            @RequestBody User user){

	        return ResponseEntity.ok(userService.updateUser(id,user));
	    }

	    // Delete user

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Long id){

	        userService.deleteUser(id);

	        return ResponseEntity.noContent().build();
	    }

	}
