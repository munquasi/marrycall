package com.muka.marry.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muka.marry.model.UserModel;
import com.muka.marry.service.EditProfileService;

@RestController
@CrossOrigin
@RequestMapping("api/edit")
public class EditProfileEndPoint {
	@Autowired
	private EditProfileService  editProfileService;
	
	@GetMapping(value="getProfile")
	private UserModel getProfile(@RequestParam("email") String email)
	{
		//int a=5/0;
		System.out.println("email_for profile edit:"+email);
		return editProfileService.getProfile(email);
	}
	

}
