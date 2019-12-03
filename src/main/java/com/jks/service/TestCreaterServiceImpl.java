package com.jks.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.jks.model.dto.AppUser;
import com.jks.model.dto.SubjectStreams;
import com.jks.model.dto.TestPaper;

@Service
public class TestCreaterServiceImpl implements TestCreaterService {

	private EntityManagerFactory entityManagerFactory;

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public List<SubjectStreams> getAllSubjects() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query query = em.createQuery("FROM SubjectStreams");
		@SuppressWarnings("unchecked")
		List<SubjectStreams> subjectsList = query.getResultList();
		em.close();
		return subjectsList;
	}

	@Override
	public String submitTest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createTest(TestPaper tPaper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletTest(int testId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TestPaper> getAllTestForSubject(String subject) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query query = em.createQuery("FROM TestPaper t where t.streams.streamName = :subject");
		query.setParameter("subject", subject);
		@SuppressWarnings("unchecked")
		List<TestPaper> subjectTests = query.getResultList();
		em.close();
		System.out.println(subjectTests);
		return subjectTests; 
	}

}
