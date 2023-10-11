package com.tpg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;
    private String subject_name;

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public Subject(int subjectId, String subject_name) {
		super();
		this.subjectId = subjectId;
		this.subject_name = subject_name;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subject_name=" + subject_name + "]";
	}

	public Subject() {
		super();
	}
	
	
    
}