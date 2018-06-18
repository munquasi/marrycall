package com.muka.marry.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muka.marry.dto.UserDTO;
import com.muka.marry.model.UserModel;
import com.muka.marry.service.SearchProfileService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class SearchProfileEndPoint {
	
	@Autowired
 	private SearchProfileService searchProfileService;
	
	@PostMapping(value="SearchProfile")
	public List<UserDTO> getSearchProfiles(@RequestBody UserDTO user)	
	{
		System.out.println("minAge:"+user.getMinAge()+"maxAge:"+user.getMaxAge()+"sex:"+user.getSex());
		
		List<UserDTO> profileList=searchProfileService.getSearchProfiles(user.getMinAge(),user.getMaxAge(),user.getReligion(),user.getCast(),user.getMotherTongue(),user.getCountry());
		UserDTO udto=new UserDTO();
		ArrayList<UserDTO> udtoList=new ArrayList<UserDTO>();
		for(int i=0;i<profileList.size();i++){
			
			udto.setPhone(profileList.get(i).getPhone());
			udto.setEmail(profileList.get(i).getEmail());
			udtoList.add(udto);
		}
			
		return udtoList;
	}

}
