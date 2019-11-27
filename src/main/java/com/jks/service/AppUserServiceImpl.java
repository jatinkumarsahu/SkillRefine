package com.jks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.jks.model.dto.AppUser;

@Service
public class AppUserServiceImpl implements AppUserService<AppUser> {

    @Autowired
    JdbcTemplate jdbcTemplate;

	
	private EntityManagerFactory entityManagerFactory;

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public List<AppUser> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser saveOrUpdate(AppUser domainObject) {
		System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"+entityManagerFactory.getProperties());
		System.out.println(jdbcTemplate.toString());
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(domainObject);
		em.getTransaction().commit();
		return domainObject;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateLogin(String emailId, String password) {
		// TODO Auto-generated method stub
		return false;
	}


}
