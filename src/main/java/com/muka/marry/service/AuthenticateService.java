package com.muka.marry.service;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticateService {

	boolean isAuthenticated(String username, String password);

	void doLogout(HttpSession sesssion);

}
