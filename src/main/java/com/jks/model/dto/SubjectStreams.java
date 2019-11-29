package com.jks.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubjectStreams {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subjectID;
	@Column(unique = true)
	private String streamName;

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public String getStreamName() {
		return streamName;
	}

	public void setStreamName(String streamName) {
		this.streamName = streamName;
	}

	@Override
	public String toString() {
		return "SubjectStreams [subjectID=" + subjectID + ", streamName=" + streamName + "]";
	}

}
