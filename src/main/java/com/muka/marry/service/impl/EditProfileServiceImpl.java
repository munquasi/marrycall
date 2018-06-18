package com.muka.marry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muka.marry.dto.UserDTO;
import com.muka.marry.model.UserModel;
import com.muka.marry.repository.UserRegistrationRepository;
import com.muka.marry.service.EditProfileService;

@Service
public class EditProfileServiceImpl implements EditProfileService {
	@Autowired
	private UserRegistrationRepository userRegistrationRepository;

	@Override
	public UserModel getProfile(String email) {
		
		return userRegistrationRepository.findByEmail(email);
	}

}
