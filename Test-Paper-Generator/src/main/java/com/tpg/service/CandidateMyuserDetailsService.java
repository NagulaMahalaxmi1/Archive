package com.tpg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tpg.entity.Admin;
import com.tpg.entity.Candidate;
import com.tpg.repository.CandidatesRepo;

@Service
public class CandidateMyuserDetailsService  implements UserDetailsService {
	
	@Autowired
	private CandidatesRepo repo;
	
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    	UserDetails user = repo.loadByusername(username);
	    	if(user==null) {
	    		throw new UsernameNotFoundException("User not found");
	    	}
	        return user;
	    }
	   
	    public String register(Candidate candidate) {
	    	int response=repo.Register(candidate);
	    	if(response>0) {
	    		return "success";
	    	}
	    	else if(response < 0) {
	    		return "Account already exists with provided details";
	    	}
	    	else {
	    		return "failure";
	    	}
	    }
	    
	   
	   

}
