package com.muka.marry.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.muka.marry.dao.SearchProfileDAO;
import com.muka.marry.dto.UserDTO;

@Repository
public class SearchProfileDAOImpl implements SearchProfileDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<UserDTO> getSearchProfiles(String lowerAge, String upperAge, String religion, String cast,
			String motherTongue, String country) {

		List<UserDTO> userDTOList = new ArrayList<UserDTO>();

		Query query = null;
		if ("none".equals(religion) && "none".equals(cast) && "none".equals(motherTongue)) {
			if (lowerAge != null && upperAge != null && country != null) {
				query = em.createNativeQuery(
						"select u.id,u.email,u.full_name,u.date_of_birth from user u WHERE  u.date_of_birth >= ? AND u.date_of_birth <=? and country=?");
				query.setParameter(1, lowerAge);
				query.setParameter(2, upperAge);
				query.setParameter(3, country);
				userDTOList = query.getResultList();
			}

		} else if ("none".equals(cast) && "none".equals(motherTongue)) {
			if (lowerAge != null && upperAge != null && country != null && religion != null) {
				query = em.createNativeQuery(
						"select u.id,u.email,u.full_name,u.date_of_birth from user u WHERE  u.date_of_birth >= ? AND u.date_of_birth <=?  and u.country=? and  u.religion=? ");
				query.setParameter(1, lowerAge);
				query.setParameter(2, upperAge);
				query.setParameter(3, country);
				query.setParameter(4, religion);
				userDTOList = query.getResultList();
			}
		} else if ("none".equals(religion) && "none".equals(motherTongue)) {
			if (lowerAge != null && upperAge != null && country != null && cast != null) {
				query = em.createNativeQuery(
						"select u.id,u.email,u.full_name,u.date_of_birth from user u WHERE  u.date_of_birth >= ? AND u.date_of_birth <=?  and u.country=? and u.cast=? ");
				query.setParameter(1, lowerAge);
				query.setParameter(2, upperAge);
				query.setParameter(3, country);
				query.setParameter(4, cast);
				userDTOList = query.getResultList();
			}
		} else if ("none".equals(cast)) {
			if (lowerAge != null && upperAge != null && country != null && religion != null && motherTongue != null) {
				query = em.createNativeQuery(
						"select u.id,u.email,u.full_name,u.date_of_birth from user u WHERE  u.date_of_birth >= ? AND u.date_of_birth <=?  and u.country=? and u.religion=? and u.mother_tongue=?");
				query.setParameter(1, lowerAge);
				query.setParameter(2, upperAge);
				query.setParameter(3, country);
				query.setParameter(4, religion);
				query.setParameter(5, motherTongue);
				userDTOList = query.getResultList();
			}
		} else if ("none".equals(religion)) {
			if (lowerAge != null && upperAge != null && country != null && cast != null && motherTongue != null) {
				query = em.createNativeQuery(
						"select u.id,u.email,u.full_name,u.date_of_birth from user u WHERE  u.date_of_birth >= ? AND u.date_of_birth <=?  and u.country=? and u.cast=? and u.mother_tongue=?");
				query.setParameter(1, lowerAge);
				query.setParameter(2, upperAge);
				query.setParameter(3, country);
				query.setParameter(4, cast);
				query.setParameter(5, motherTongue);
				userDTOList = query.getResultList();
			}
		}
		else {
		
		if (lowerAge != null && upperAge != null && country != null && cast != null && motherTongue != null && religion!=null) {
			query = em.createNativeQuery(
					"select u.id,u.phone,u.email,u.gender,u.full_name,u.date_of_birth from user u WHERE  u.date_of_birth >= ? AND u.date_of_birth <=?  and u.country=? and u.cast=? and u.mother_tongue=? and u.religion=?");
			query.setParameter(1, lowerAge);
			query.setParameter(2, upperAge);
			query.setParameter(3, country);
			query.setParameter(4, cast);
			query.setParameter(5, motherTongue);
			query.setParameter(6, religion);
			userDTOList = query.getResultList();
		}
	 }
		return userDTOList;
	}

}
