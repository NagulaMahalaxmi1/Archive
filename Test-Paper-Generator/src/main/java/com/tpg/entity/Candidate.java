package com.tpg.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Candidate {
	
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidateId;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private Long phoneNo;
    private String name;
    
    @ManyToOne
    private TestPaper test;

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TestPaper getTest() {
		return test;
	}

	public void setTest(TestPaper test) {
		this.test = test;
	}
	
	public Candidate() {
		
	}

	public Candidate(Long candidateId, String username, String email, String password, Long phoneNo, String name,
			TestPaper test) {
		super();
		this.candidateId = candidateId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.name = name;
		this.test = test;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", username=" + username + ", email=" + email + ", password="
				+ password + ", phoneNo=" + phoneNo + ", name=" + name + ", test=" + test + "]";
	}

   
	
    
    
}