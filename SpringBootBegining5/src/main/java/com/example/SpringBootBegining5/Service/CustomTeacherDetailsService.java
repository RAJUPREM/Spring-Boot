package com.example.SpringBootBegining5.Service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomTeacherDetailsService implements UserDetailsService{
	
	

	@Override
	public UserDetails loadUserByUsername(String teacherName) throws UsernameNotFoundException {
		
//		Optional<Teacher> tempTeacher=teacherRepository.findById(teacherName);
//		Teacher teacher=tempTeacher.get();
		
		if(teacherName.equals("Apurba"))
		{
			return new User("Apurba","Apurba@1234",new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("Teacher does not present");
		}
		
		
		
	}

	

}
