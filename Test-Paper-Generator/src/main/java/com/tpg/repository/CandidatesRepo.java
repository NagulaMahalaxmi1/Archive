package com.tpg.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.tpg.entity.AuthenticationRequest;
import com.tpg.entity.Candidate;

@Repository
public class CandidatesRepo {
	@Autowired
	private JdbcTemplate temp;
	
	public UserDetails loadByusername(String username) {
		
		String sql="select* from candidate where username=?";
		AuthenticationRequest auth = temp.queryForObject(sql, new Object[] {username},new AuthMapper() );
		return new User(auth.getUsername(),auth.getPassword(),new ArrayList<>());
	}
	
	public Integer Register(Candidate candidate) {
		try {
		String sql = "insert into candidate(username,email,password,phone_no,name) values(?,?,?,?,?)";
		return temp.execute(sql,new PreparedStatementCallback<Integer>() {
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, candidate.getUsername());
				ps.setString(2, candidate.getEmail());
				ps.setString(3, candidate.getPassword());
				ps.setLong(4, candidate.getPhoneNo());
				ps.setString(5, candidate.getName());
				int a=ps.executeUpdate();
				return a;
			}
			
			});
		}
		
		
		catch(DuplicateKeyException e) {
			e.printStackTrace();
			return -1;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	

}