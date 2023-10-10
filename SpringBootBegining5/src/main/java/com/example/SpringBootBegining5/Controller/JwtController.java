package com.example.SpringBootBegining5.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootBegining5.Entity.JwtTokenClass;
import com.example.SpringBootBegining5.Service.CustomTeacherDetailsService;
import com.example.SpringBootBegining5.helper.JwtUtilClass;

@RestController
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtilClass jwtUtilClass;
	
	@Autowired
	private CustomTeacherDetailsService customTeacherDetailsService;
	
	@PostMapping("/generateToken")
	public ResponseEntity<String> generateToken(@RequestBody JwtTokenClass jwtTokenClass) throws Exception
	{
		System.out.println(jwtTokenClass);
		try
		{
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtTokenClass.getUsername(),jwtTokenClass.getPassword()));
		}
		catch(UsernameNotFoundException ex)
		{
			ex.printStackTrace();
			throw new Exception("Teacher does not exist");
		}
		
		UserDetails userDetails=customTeacherDetailsService.loadUserByUsername(jwtTokenClass.getUsername());
		
		String token=jwtUtilClass.generateToken(userDetails);
		
		return new ResponseEntity<>(token,HttpStatus.OK);
		
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public JwtUtilClass getJwtUtilClass() {
		return jwtUtilClass;
	}

	public void setJwtUtilClass(JwtUtilClass jwtUtilClass) {
		this.jwtUtilClass = jwtUtilClass;
	}

	public CustomTeacherDetailsService getCustomTeacherDetailsService() {
		return customTeacherDetailsService;
	}

	public void setCustomTeacherDetailsService(CustomTeacherDetailsService customTeacherDetailsService) {
		this.customTeacherDetailsService = customTeacherDetailsService;
	}

}
