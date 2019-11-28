package com.jks.service;

import java.util.List;


import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
		em.close();
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
		em.close();
		if (lUsers.size() > 0)
			return true;
		else
			return false;
	}

	public String createUser(AppUser appUser) {
		String result;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
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
		} finally {
			em.close();
		}
		return result;
	}

	public boolean getUserByEmail(String email) {
		EntityManager em = entityManagerFactory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AppUser> cq = cb.createQuery(AppUser.class);

		Root<AppUser> user = cq.from(AppUser.class);
		Predicate emailPredicate = cb.equal(user.get("userEmail"), email);
		cq.where(emailPredicate);

		TypedQuery<AppUser> query = em.createQuery(cq);
		System.out.println(email + " : " + query.getResultList());
		if (query.getResultList().size() > 0) {
			em.close();
			return false;
		} else {
			em.close();
			return true;
		}
	}
}
