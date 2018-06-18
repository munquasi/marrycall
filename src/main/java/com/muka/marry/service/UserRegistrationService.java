package com.muka.marry.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.muka.marry.dto.UserDTO;
import com.muka.marry.model.UserModel;
@Service
public interface UserRegistrationService {

	public void registerUser(UserModel user);

	public List<UserModel> getUsers();

	public UserModel getUser(Long id);

	public void deleteUser(Long id);

	public void updateUser(UserModel user);

	public UserDTO searchUser(String item);

}
