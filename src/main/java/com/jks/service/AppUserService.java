package com.jks.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jks.model.dto.AppUser;

@Repository
public interface AppUserService<AppUser> {
	List<AppUser> listAll();

	AppUser getById(Integer id);

	AppUser saveOrUpdate(AppUser domainObject);

	void delete(Integer id);

	String validateLogin(String emailId, String password);

	String createUser(AppUser appUser);

	boolean getUserByEmail(String email);
}
