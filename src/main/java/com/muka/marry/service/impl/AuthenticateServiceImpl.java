package com.muka.marry.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.muka.marry.constants.UserRegistrationConstant;
import com.muka.marry.dao.UserDao;
import com.muka.marry.dto.LoginDTO;
import com.muka.marry.service.AuthenticateService;
import com.muka.marry.util.PasswordEncryptUtil;


@Service
public class AuthenticateServiceImpl implements AuthenticateService {

	@Autowired
	UserDao userDao;

	@Override
	public boolean isAuthenticated(String email, String password) {

		LoginDTO loginDto = userDao.getUserNameAndPassword(email);
		String emailFromDB = loginDto.getEmail();
		String passwordFromDB = loginDto.getPassword();
		String securePassword = PasswordEncryptUtil.getSha256Hash(password + UserRegistrationConstant.salt);
		if (securePassword.equals(passwordFromDB) && email.equals(emailFromDB)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void doLogout(HttpSession sesssion) {
		String id=sesssion.getId();
		System.out.println("id:"+id);
		sesssion.invalidate();
		String id2=sesssion.getId();
		System.out.println("id2:"+id2);
		
	}

}
