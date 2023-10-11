package com.tpg.entity;

import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "section")
public class Section {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int section_id;
    private Time timer;
    private int numberOfQuestions;

//    @JoinColumn(name = "q_id")
    @OneToMany(mappedBy = "sectionquestions", cascade = CascadeType.ALL) // Updated mappedBy and added cascade
    private List<Question> questions;
    
//    @OneToMany(mappedBy = "sectionGeneratedQuestions", cascade = CascadeType.ALL)
    private Question generatedQuestions;   
    
    @OneToOne
    @JoinColumn(name = "subject_id")
	public Subject subject;
    
    public Section() {
    }

	public int getSection_id() {
		return section_id;
	}

	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}

	public Time getTimer() {
		return timer;
	}

	public void setTimer(Time timer) {
		this.timer = timer;
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question getGeneratedQuestions() {
		return generatedQuestions;
	}

	public void setGeneratedQuestions(Question generatedQuestions) {
		this.generatedQuestions = generatedQuestions;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Section [section_id=" + section_id + ", timer=" + timer + ", numberOfQuestions=" + numberOfQuestions
				+ ", questions=" + questions + ", generatedQuestions=" + generatedQuestions + ", subject=" + subject
				+ "]";
	}

	public Section(int section_id, Time timer, int numberOfQuestions, List<Question> questions,
			Question generatedQuestions, Subject subject) {
		super();
		this.section_id = section_id;
		this.timer = timer;
		this.numberOfQuestions = numberOfQuestions;
		this.questions = questions;
		this.generatedQuestions = generatedQuestions;
		this.subject = subject;
	}

	
	 
}