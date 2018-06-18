package com.muka.marry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muka.marry.dao.SearchProfileDAO;
import com.muka.marry.dto.UserDTO;
import com.muka.marry.service.SearchProfileService;

@Service
public class SearchProfileServiceImpl implements SearchProfileService {

	@Autowired
	SearchProfileDAO searchProfileDAO;

	@Override
	public List<UserDTO> getSearchProfiles(String lowerAgeLimit, String upperAgeLimit, String religion, String cast,
			String motherTongue, String country) {
		return searchProfileDAO.getSearchProfiles(lowerAgeLimit, upperAgeLimit, religion, cast, motherTongue, country);

	}

}
