package com.tpg.repository;

import java.sql.ResultSet;



import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tpg.entity.AuthenticationRequest;





public class AuthMapper implements RowMapper<AuthenticationRequest> {

	@Override
	public AuthenticationRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		AuthenticationRequest auth = new AuthenticationRequest();
		auth.setUsername(rs.getString("username"));
		auth.setPassword(rs.getString("password"));
		
		return auth;
	}

}
