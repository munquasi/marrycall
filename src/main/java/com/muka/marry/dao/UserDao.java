package com.muka.marry.dao;

import com.muka.marry.dto.LoginDTO;

public interface UserDao {
	public LoginDTO getUserNameAndPassword(String email);

}
