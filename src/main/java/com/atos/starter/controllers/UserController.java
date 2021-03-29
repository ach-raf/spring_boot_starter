package com.atos.starter.controllers;

import com.atos.starter.dao.UserRepository;
import com.atos.starter.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@RestController
// Adding /api to every route
@RequestMapping("/api")
// Accept Cross origin calls
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
public class UserController {
	private final UserRepository user_repo;
	
	public UserController(UserRepository user_repo) {
		this.user_repo = user_repo;
	}
	// Get a list of all users
	@GetMapping("/users")
    Collection<User> Users() {
        return (List<User>) user_repo.findAll();
    }
	// Get a single user by id
    @GetMapping("/user/{id}")
    ResponseEntity<?> getGroup(@PathVariable String id) {
        Optional<User> user = user_repo.findById(id);
        return user.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // Update user method
    @PutMapping("/user/{id}")
    ResponseEntity<User> updateUser(@RequestBody User user) {
        User result = user_repo.save(user);
        return ResponseEntity.ok().body(result);
    }

}
