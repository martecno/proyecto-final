package com.profinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profinal.entities.User;
import com.profinal.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User save(User user) {
		return userRepository.saveAndFlush(user);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getId(Long id) {
		return userRepository.findById(id);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}