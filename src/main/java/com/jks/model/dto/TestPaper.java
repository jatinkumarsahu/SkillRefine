package com.jks.model.dto;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestPaper {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int testId;
	String testTitle;
	List<QuestionAnswers> questionListWithAnswers;

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public List<QuestionAnswers> getQuestionListWithAnswers() {
		return questionListWithAnswers;
	}

	public void setQuestionListWithAnswers(List<QuestionAnswers> questionListWithAnswers) {
		this.questionListWithAnswers = questionListWithAnswers;
	}

}
