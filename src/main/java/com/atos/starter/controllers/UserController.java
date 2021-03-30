package com.atos.starter.controllers;

import com.atos.starter.dao.UserRepository;
import com.atos.starter.models.User;
import com.atos.starter.services.UserService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class UserController {
	private final UserService userService;

	// Get a list of all users
	@GetMapping("/users")
    Collection<User> Users() {
        return userService.findAll();
    }
	// Get a single user by id
    @GetMapping("/user/{id}")
    ResponseEntity<?> getGroup(@PathVariable String id) {
        Optional<User> user = userService.findById(id);
        return user.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // Update user method
    @PutMapping("/user/{id}")
    ResponseEntity<User> updateUser(@RequestBody User user) {
        User result = userService.add(user);
        return ResponseEntity.ok().body(result);
    }

}
