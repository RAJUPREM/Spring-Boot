package com.example.SpringBootBegining5.Entity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//import com.example.SpringBootBegining5.Repsitory.TeacherRepository;

public class Teacher implements UserDetails{
	
//	@Autowired
//	private TeacherRepository teacherRepository;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

//	public TeacherRepository getTeacherRepository() {
//		return teacherRepository;
//	}
//
//	public void setTeacherRepository(TeacherRepository teacherRepository) {
//		this.teacherRepository = teacherRepository;
//	}

}
