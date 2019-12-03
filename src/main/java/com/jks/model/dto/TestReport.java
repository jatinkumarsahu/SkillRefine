package com.jks.model.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int reportId;
	int testId;
	int corrrectAnswers;
	Date submissionDate;
	String userEmail;

	public TestReport() {
		super();
	}

	public TestReport(int testId, int corrrectAnswers, Date submissionDate, String userEmail) {
		super();
		this.testId = testId;
		this.corrrectAnswers = corrrectAnswers;
		this.submissionDate = submissionDate;
		this.userEmail = userEmail;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getCorrrectAnswers() {
		return corrrectAnswers;
	}

	public void setCorrrectAnswers(int corrrectAnswers) {
		this.corrrectAnswers = corrrectAnswers;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "TestReport [reportId=" + reportId + ", testId=" + testId + ", corrrectAnswers=" + corrrectAnswers
				+ ", submissionDate=" + submissionDate + ", userEmail=" + userEmail + "]";
	}

}
