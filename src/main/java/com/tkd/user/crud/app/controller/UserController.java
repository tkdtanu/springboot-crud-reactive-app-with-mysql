package com.tkd.user.crud.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tkd.user.crud.app.dto.User;
import com.tkd.user.crud.app.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public Flux<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public Mono<User> getUser(@PathVariable Integer id) {
		return userService.getUser(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteUser(@PathVariable Integer id) {
		return userService.deleteUser(id);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteAllUser() {
		return userService.deleteAllUsers();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<User> createUser(@Valid @RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
}
