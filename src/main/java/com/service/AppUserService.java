package com.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.dto.AppUser;

public interface AppUserService extends CrudRepository<AppUser, Integer> {

}
