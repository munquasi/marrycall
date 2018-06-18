package com.muka.marry.endpoints;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.muka.marry.dto.LoginDTO;
import com.muka.marry.service.AuthenticateService;

@RestController
@CrossOrigin
@RequestMapping("api")

public class AuthenticateEndPoint {
	@Autowired
	public AuthenticateService authenticateService;
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	//public boolean authenticate(@RequestParam("email") String email,@RequestParam("password") String password)
	public boolean authenticate(@RequestBody LoginDTO loginDto)

	{
		System.out.println("username:"+loginDto.getEmail()+"password:"+loginDto.getPassword());
		return authenticateService.isAuthenticated(loginDto.getEmail(),loginDto.getPassword());
		
	}
	
	@GetMapping("logout")
	public boolean logout(HttpSession sesssion)
	{
	
	 authenticateService.doLogout(sesssion);	
	 return true;	
	}
	
	}
