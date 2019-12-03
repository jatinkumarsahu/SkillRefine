package com.jks.service;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Repository;

import com.jks.model.dto.SubjectStreams;
import com.jks.model.dto.TestPaper;

public interface TestCreaterService {

	public List<SubjectStreams> getAllSubjects();

	public String submitTest();

	public String createTest(TestPaper tPaper);
	
	public void deletTest(int testId);
	
	public List<TestPaper> getAllTestForSubject(String subject);
	
	public TestPaper getTestPaperById(int testId);

}
