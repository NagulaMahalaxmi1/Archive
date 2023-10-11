package com.tpg.entity;

import javax.persistence.Entity;
import javax .persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SectionAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer analysis_id;
    private Integer attempted;
    private Integer notAttempted;
    private Boolean flag;
    private Integer reportedQuestions;
    private String selectedOption;
    
    @OneToOne
    @JoinColumn(name = "section_id")
    private Section section;

	public Integer getAnalysis_id() {
		return analysis_id;
	}

	public void setAnalysis_id(Integer analysis_id) {
		this.analysis_id = analysis_id;
	}

	public Integer getAttempted() {
		return attempted;
	}

	public void setAttempted(Integer attempted) {
		this.attempted = attempted;
	}

	public Integer getNotAttempted() {
		return notAttempted;
	}

	public void setNotAttempted(Integer notAttempted) {
		this.notAttempted = notAttempted;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Integer getReportedQuestions() {
		return reportedQuestions;
	}

	@Override
	public String toString() {
		return "SectionAnalysis [analysis_id=" + analysis_id + ", attempted=" + attempted + ", notAttempted="
				+ notAttempted + ", flag=" + flag + ", reportedQuestions=" + reportedQuestions + ", selectedOption="
				+ selectedOption + ", section=" + section + "]";
	}

	public void setReportedQuestions(Integer reportedQuestions) {
		this.reportedQuestions = reportedQuestions;
	}

	public String getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public SectionAnalysis(Integer analysis_id, Integer attempted, Integer notAttempted, Boolean flag,
			Integer reportedQuestions, String selectedOption, Section section) {
		super();
		this.analysis_id = analysis_id;
		this.attempted = attempted;
		this.notAttempted = notAttempted;
		this.flag = flag;
		this.reportedQuestions = reportedQuestions;
		this.selectedOption = selectedOption;
		this.section = section;
	}
}

   

	