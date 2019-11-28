package com.jks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import com.jks.model.dto.AppUser;

@Service
public class AppUserServiceImpl implements AppUserService<AppUser> {

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

		return null;
	}

	@Override
	public AppUser getById(Integer id) {

		return null;
	}

	@Override
	public AppUser saveOrUpdate(AppUser domainObject) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(domainObject);
		em.getTransaction().commit();
		return domainObject;
	}

	@Override
	public void delete(Integer id) {

	}

	@Override
	public boolean validateLogin(String emailId, String password) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query query = em.createQuery("FROM AppUser ap WHERE ap.userEmail = :aId and ap.userPassword = :aPwd");
		query.setParameter("aId", emailId);
		query.setParameter("aPwd", password);
		List<?> lUsers = query.getResultList();
		System.err.println("HHHJJJ " + lUsers);
		if (lUsers.size() > 0)
			return true;
		else
			return false;
	}

	public String createUser(AppUser appUser) {
		String result;
		try {
			EntityManager em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(appUser);
			em.getTransaction().commit();
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			if (e.getClass().isInstance(RollbackException.class)) {
				result = "Email Id Exists";
			} else
				result = "Some Error occured";
		}
		return result;
	}

}
