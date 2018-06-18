package com.muka.marry.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.muka.marry.dao.UserDao;
import com.muka.marry.dto.LoginDTO;

@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public LoginDTO getUserNameAndPassword(String email) {
		
		Query q = em.createNativeQuery("SELECT u.email, u.password FROM user u WHERE u.email = ?");
		q.setParameter(1, email);
		Object[] arr = (Object[]) q.getSingleResult();
			LoginDTO loginDto=new LoginDTO();
		loginDto.setEmail(arr[0].toString());
		loginDto.setPassword(arr[1].toString());
		
		return loginDto;
	}

}
