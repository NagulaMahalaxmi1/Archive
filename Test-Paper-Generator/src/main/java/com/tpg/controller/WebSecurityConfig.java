package com.tpg.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tpg.security.JwtRequestFilter;
//import com.tpg.service.AdminMyUserDetailsService;
import com.tpg.service.CandidateMyuserDetailsService;



@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	private CandidateMyuserDetailsService myUserDetailsServicee;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsServicee);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
				.authorizeRequests().antMatchers("/authenticate","/api/candidate/signup","/candidate/loginuser/{token}","/sections/all","/sections/create","/sections/update/{section_id}","/sections/delete/{section_id}","/sections/id/{section_id}","/subjects/create","/questions/createMultiple","/sections/generate?subjectId={}&numberOfQuestions={}").permitAll().
						anyRequest().authenticated().and().
						exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}

}

//"/admin/loginuser/{token}","/candidate/loginuser/{token}",

