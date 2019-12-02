package com.jks.service;

import java.util.ArrayList;
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
import com.jks.model.dto.QuestionAnswers;
import com.jks.model.dto.SubjectStreams;
import com.jks.model.dto.TestPaper;

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
	public String validateLogin(String emailId, String password) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query query = em.createQuery("FROM AppUser ap WHERE ap.userEmail = :aId and ap.userPassword = :aPwd");
		query.setParameter("aId", emailId);
		query.setParameter("aPwd", password);
		@SuppressWarnings("unchecked")
		List<AppUser> lUsers = query.getResultList();
		
//		em.getTransaction().begin();
//		List<QuestionAnswers> lQuestionAnswers = new ArrayList<QuestionAnswers>();
//		lQuestionAnswers.add(new QuestionAnswers("Q1", "A1", "B1", "C1", "D1"));
//		lQuestionAnswers.add(new QuestionAnswers("Q2", "A2", "B2", "C2", "D2"));
//		lQuestionAnswers.add(new QuestionAnswers("Q3", "A3", "B3", "C3", "D3"));
//		lQuestionAnswers.add(new QuestionAnswers("Q4", "A4", "B4", "C4", "D4"));
//		SubjectStreams streams = new SubjectStreams("C++");
//		streams.setSubjectID(998);
//		TestPaper tPaper = new TestPaper("TEST1", lQuestionAnswers, streams);
//		em.merge(tPaper);
//		em.getTransaction().commit();

		em.close();
		if (lUsers.size() > 0)
			return lUsers.get(0).getFirstName();
		else
			return "Not Found";
	}

	@Override
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

	@Override
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
