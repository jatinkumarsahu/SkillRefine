package com.jks.service;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Repository;

import com.jks.model.dto.SubjectStreams;

public interface TestCreaterService {

	public List<SubjectStreams> getAllSubjects();
	
}
