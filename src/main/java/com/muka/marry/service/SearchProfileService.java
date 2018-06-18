package com.muka.marry.service;

import java.util.List;

import com.muka.marry.dto.UserDTO;

public interface SearchProfileService {

	List<UserDTO> getSearchProfiles(String lowerAgeLimit,String upperAgeLimit, String religion, String cast, String motherTongue, String country);

}
