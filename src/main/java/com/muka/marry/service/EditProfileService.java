package com.muka.marry.service;

import com.muka.marry.dto.UserDTO;
import com.muka.marry.model.UserModel;

public interface EditProfileService {

	UserModel getProfile(String email);

}
