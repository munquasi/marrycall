package com.muka.marry.service.impl;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.muka.marry.constants.UserRegistrationConstant;
import com.muka.marry.dto.UserDTO;
import com.muka.marry.model.UserModel;
import com.muka.marry.repository.UserRegistrationRepository;
import com.muka.marry.service.UserRegistrationService;
import com.muka.marry.util.EmailUtil;
import com.muka.marry.util.PasswordEncryptUtil;


public class UserRegistrationServiceImpl implements UserRegistrationService {
	public static final Logger LOGGER=Logger.getLogger(UserRegistrationServiceImpl.class.getName());
	Long userId=null;

	@Autowired
	UserRegistrationRepository userRegistrationRepository;
	@Override
	public void registerUser(UserModel user) {
		
		if(user!=null && userId!=null){
			inserInRemainingColumns(user,userId);
			EmailUtil.sendRegistrationEmail(user);
			userId=null;
		} else {
			user.setPassword(PasswordEncryptUtil.getSha256Hash(user.getPassword()+UserRegistrationConstant.salt));;
			 userRegistrationRepository.saveAndFlush(user);
			 userId=user.getId();
			 LOGGER.info("currently created UserId:"+userId);
		}
	}
	@Override
	public List<UserModel> getUsers() {
		return userRegistrationRepository.findAll();
	}
	@Override
	public UserModel getUser(Long id) {
		return userRegistrationRepository.findOne(id);
	}
	@Override
	public void deleteUser(Long id) {
		 userRegistrationRepository.delete(id);
	}
	@Override
	public void updateUser(UserModel userFromUI) {
		
	     userRegistrationRepository.saveAndFlush(userFromUI);
		
	}
	@Override
	public UserDTO searchUser(String item) {
		UserModel userRegistration = userRegistrationRepository.findById(new Long(item));
		UserDTO user=new UserDTO();
		user.setId(userRegistration.getId());
		user.setEmail(userRegistration.getEmail());
		user.setGender(userRegistration.getGender());
		user.setPhone(userRegistration.getPhone());
		user.setProfileFor(userRegistration.getProfileFor());
		user.setPassword(userRegistration.getPassword());
		return user;
	}
	
	private void inserInRemainingColumns(UserModel userFromUI,Long id)
	{
		UserModel userFromDB=userRegistrationRepository.findOne(id);
		 LOGGER.info("currently created User Id  From DB:"+userFromDB.getId());
		if(userFromDB.getEmail()!=null){
			userFromUI.setEmail(userFromDB.getEmail());
		}
		if(userFromDB.getPhone()!=null){
			userFromUI.setPhone(userFromDB.getPhone());
		}
		if(userFromDB.getPassword()!=null){
			userFromUI.setPassword(userFromDB.getPassword());
		}
		if(userFromDB.getProfileFor()!=null){
			userFromUI.setProfileFor(userFromDB.getProfileFor());
		}
		if(userFromDB.getGender()!=null){
			userFromUI.setGender(userFromDB.getGender());
		}
		   userFromUI.setId(id);
		   userRegistrationRepository.saveAndFlush(userFromUI);
		   LOGGER.info("currently saved  User in DB:"+userFromUI);
		
	}

}
