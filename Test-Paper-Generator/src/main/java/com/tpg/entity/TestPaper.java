package com.tpg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "testpaper")
public class TestPaper {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long test_id;

    private Integer test_marks;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date date;

    public TestPaper() {
    }

	public TestPaper(Long test_id, Integer test_marks, Date date) {
		super();
		this.test_id = test_id;
		this.test_marks = test_marks;
		this.date = date;
	}

	public Long getTest_id() {
		return test_id;
	}

	public void setTest_id(Long test_id) {
		this.test_id = test_id;
	}

	public Integer getTest_marks() {
		return test_marks;
	}

	public void setTest_marks(Integer test_marks) {
		this.test_marks = test_marks;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TestPaper [test_id=" + test_id + ", test_marks=" + test_marks + ", date=" + date + "]";
	}
    
    
}
