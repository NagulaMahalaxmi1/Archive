//package com.tpg.repository;
//
//
//import java.sql.PreparedStatement;
//
//
//
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementCallback;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Repository;
//
//import com.tpg.entity.Admin;
//import com.tpg.entity.AuthenticationRequest;
//
//
//
//@Repository
//public class Adminrepository{
//	@Autowired
//	private JdbcTemplate temp;
//	
//	public UserDetails loadByusername(String username) {
//		
//		String sql="select* from admin where username=?";
//		AuthenticationRequest auth = temp.queryForObject(sql, new Object[] {username},new AuthMapper() );
//		return new User(auth.getUsername(),auth.getPassword(),new ArrayList<>());
//	}
//	
//	public Integer Register(Admin admin) {
//		try {
//		String sql = "insert into admin(username,email,password) values(?,?,?)";
//		return temp.execute(sql,new PreparedStatementCallback<Integer>() {
//			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
//				ps.setString(1, admin.getUsername());
//				ps.setString(2, admin.getEmail());
//				ps.setString(3, admin.getPassword());
//				int a=ps.executeUpdate();
//				return a;
//			}
//			
//			});
//		}
//		
//		
//		catch(DuplicateKeyException e) {
//			e.printStackTrace();
//			return -1;
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			return 0;
//		}
//	}
//	
//
//}
