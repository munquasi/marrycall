package com.muka.marry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muka.marry.dto.UserDTO;
import com.muka.marry.model.UserModel;

public interface UserRegistrationRepository extends JpaRepository<UserModel, Long> {
	
	public UserModel findById(Long item);

	public UserModel findByEmail(String email);

}
