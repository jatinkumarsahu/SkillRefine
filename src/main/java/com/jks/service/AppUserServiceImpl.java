package com.jks.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.jks.model.dto.AppUser;

@Service
public class AppUserServiceImpl implements AppUserService{

	@Override
	public <S extends AppUser> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AppUser> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AppUser> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<AppUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<AppUser> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AppUser entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends AppUser> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
