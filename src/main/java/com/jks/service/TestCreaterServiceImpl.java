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
		System.err.println("HHHJJJ " + subjectsList);
		em.close();
		return subjectsList;
	}

}
