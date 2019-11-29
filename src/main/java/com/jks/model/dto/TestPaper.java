package com.jks.model.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class TestPaper {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int testId;
	String testTitle;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "test_id")
	List<QuestionAnswers> questionListWithAnswers;

	
	
	public TestPaper() {
		super();
	}

	public TestPaper(String testTitle, List<QuestionAnswers> questionListWithAnswers) {
		super();
		this.testTitle = testTitle;
		this.questionListWithAnswers = questionListWithAnswers;
	}

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

	@Override
	public String toString() {
		return "TestPaper [testId=" + testId + ", testTitle=" + testTitle + ", questionListWithAnswers="
				+ questionListWithAnswers + "]";
	}

}
