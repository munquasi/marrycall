package com.muka.marry.endpoints;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.muka.marry.dto.UserDTO;
import com.muka.marry.model.UserModel;
import com.muka.marry.service.UserRegistrationService;
import com.muka.marry.util.EmailUtil;

@CrossOrigin
@RestController
@RequestMapping("api")
public class UserRegistrationEndPoint {
	
	
	@Autowired
	//@Qualifier(UserRegistrationConstant.USER_REG_SERVICE)
	private UserRegistrationService userRegistrationService;
	@CrossOrigin
	@RequestMapping(value="createOrUpdateUser" , method=RequestMethod.POST)
	public void onRegister(@RequestBody UserModel user){
			userRegistrationService.registerUser(user);
		}
		
		
		//HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("/register/{id}").buildAndExpand(user.getId()).toUri());
		//return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		 //return new ResponseEntity<Void>(HttpStatus.OK);
	
	
	@RequestMapping(value="getUsers", method=RequestMethod.GET)
	public List<UserModel> getUsers(){
		return userRegistrationService.getUsers();
	}
	
	@RequestMapping(value="getUser/{id}", method=RequestMethod.GET)
	public UserModel getUser(@PathVariable("id") Long id){
		return userRegistrationService.getUser(id);
	}
	
	@RequestMapping(value="deleteUser/{id}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Long id){
		 userRegistrationService.deleteUser(id);
	}
	
	@RequestMapping(value="updateUser/{id}", method=RequestMethod.PUT)
	public void updateUser(@PathVariable("id") Long id, @RequestBody UserModel user){
		user.setId(id);
		userRegistrationService.updateUser(user);
	}
	
	@RequestMapping(value="searchUser/{item}", method=RequestMethod.GET)
	public UserDTO searchUser(@PathVariable("item") String item){
		return userRegistrationService.searchUser(item);
	}
	
	@GetMapping(value="sendEmail")
	public void sendMail(){
		EmailUtil.sendEmail();
	}

}
