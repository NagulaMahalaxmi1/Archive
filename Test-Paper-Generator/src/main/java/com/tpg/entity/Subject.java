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
    private int subject_id;
    private String Subject_name;
    
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubject_name() {
		return Subject_name;
	}
	public void setSubject_name(String subject_name) {
		Subject_name = subject_name;
	}
	
	public Subject(int subject_id, String subject_name) {
		super();
		this.subject_id = subject_id;
		Subject_name = subject_name;
	}
	
	public Subject() {
		super();
	}
	
	@Override
	public String toString() {
		return "Subject [subject_id=" + subject_id + ", Subject_name=" + Subject_name + "]";
	}
    
    
    
}