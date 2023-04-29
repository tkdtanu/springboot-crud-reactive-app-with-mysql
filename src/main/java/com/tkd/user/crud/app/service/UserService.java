package com.tkd.user.crud.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tkd.user.crud.app.dto.User;
import com.tkd.user.crud.app.repositories.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Flux<User> getAllUsers() {
		return userRepository.findAll().map(User::entityToDto);
	}

	public Mono<User> getUser(Integer id) {
		return userRepository.findById(id).map(User::entityToDto);
	}

	public Mono<User> createUser(User user) {
		return userRepository.save(user.toEntity()).map(User::entityToDto);
	}

	public Mono<User> updateUser(Integer id, User user) {
		return userRepository.findById(id).flatMap(entity -> {
			entity.setAddress(user.getAddress());
			entity.setName(user.getName());
			entity.setDob(user.getDob());
			return userRepository.save(entity).map(User::entityToDto);
		});
	}

	public Mono<Void> deleteUser(Integer id) {
		return userRepository.deleteById(id);
	}

	public Mono<Void> deleteAllUsers() {
		return userRepository.deleteAll();
	}
}
