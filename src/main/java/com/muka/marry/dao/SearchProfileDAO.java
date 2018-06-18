package com.muka.marry.dao;

import java.util.List;

import com.muka.marry.dto.UserDTO;

public interface SearchProfileDAO {

	List<UserDTO> getSearchProfiles(String lowerAgeLimit,String upperAgeLimit, String religion, String cast, String motherTongue, String country);

}
