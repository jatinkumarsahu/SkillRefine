package com.jks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jks.model.dto.AppUser;

@Service
public class AppUserServiceImpl {

	@Autowired
	AppUserService appUserService;

	public void saveUser(AppUser appUser) {
		appUserService.save(appUser);
	}

}
