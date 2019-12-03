package com.jks.model.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class TestPaper {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int testId;

	String testTitle;

	int totalQuestions;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "test_id")
	List<QuestionAnswers> questionListWithAnswers;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	SubjectStreams streams;

	public TestPaper() {
		super();
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

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public List<QuestionAnswers> getQuestionListWithAnswers() {
		return questionListWithAnswers;
	}

	public void setQuestionListWithAnswers(List<QuestionAnswers> questionListWithAnswers) {
		this.questionListWithAnswers = questionListWithAnswers;
	}

	public SubjectStreams getStreams() {
		return streams;
	}

	public void setStreams(SubjectStreams streams) {
		this.streams = streams;
	}

	public TestPaper(String testTitle, int totalQuestions, List<QuestionAnswers> questionListWithAnswers,
			SubjectStreams streams) {
		super();
		this.testTitle = testTitle;
		this.totalQuestions = totalQuestions;
		this.questionListWithAnswers = questionListWithAnswers;
		this.streams = streams;
	}

	@Override
	public String toString() {
		return "TestPaper [testId=" + testId + ", testTitle=" + testTitle + ", totalQuestions=" + totalQuestions
				+ ", questionListWithAnswers=" + questionListWithAnswers + ", streams=" + streams + "]";
	}

}
