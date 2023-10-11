package com.tpg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import java.util.Date;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;
    private int totalMarks;
    private int score;
    private double percentage;
    private Date startTime;
    private Date endTime;
    
    @ManyToOne
    @JoinColumn(name = "analysis_id")
    private SectionAnalysis sectionanalysis;
    
    @OneToOne
    @JoinColumn(name = "test_id")
    private TestPaper testpaper;

	public Report(int reportId, int totalMarks, int score, double percentage, Date startTime, Date endTime,
			SectionAnalysis sectionanalysis, TestPaper testpaper) {
		super();
		this.reportId = reportId;
		this.totalMarks = totalMarks;
		this.score = score;
		this.percentage = percentage;
		this.startTime = startTime;
		this.endTime = endTime;
		this.sectionanalysis = sectionanalysis;
		this.testpaper = testpaper;
	}

	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", totalMarks=" + totalMarks + ", score=" + score + ", percentage="
				+ percentage + ", startTime=" + startTime + ", endTime=" + endTime + ", sectionanalysis="
				+ sectionanalysis + ", testpaper=" + testpaper + "]";
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public SectionAnalysis getSectionanalysis() {
		return sectionanalysis;
	}

	public void setSectionanalysis(SectionAnalysis sectionanalysis) {
		this.sectionanalysis = sectionanalysis;
	}

	public TestPaper getTestpaper() {
		return testpaper;
	}

	public void setTestpaper(TestPaper testpaper) {
		this.testpaper = testpaper;
	}
    

    
}
