package com.profinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profinal.entities.Admin;
import com.profinal.repositories.AdminRepository;

@Service
public class AdminService {
	private final AdminRepository adminRepository;

	@Autowired
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	public Admin save(Admin admin) {
		return adminRepository.saveAndFlush(admin);
	}

	public List<Admin> getAdmins() {
		return adminRepository.findAll();
	}
}