package com.example.SpringBootBegining5.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.SpringBootBegining5.Entity.Teacher;
import com.example.SpringBootBegining5.Repsitory.TeacherRepository;

@Service
public class CustomTeacherDetailsService implements UserDetailsService{
	
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public UserDetails loadUserByUsername(String teacherUsername) throws UsernameNotFoundException {
		
//		Optional<Teacher> tempTeacher=teacherRepository.findById(teacherName);
//		Teacher teacher=tempTeacher.get();
		
		if(teacherUsername.equals("Apurba"))
		{
			return new User("Apurba","Apurba@1234",new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("Teacher does not present");
		}
		
//		try {
//		Optional<Teacher> tempTeacher=teacherRepository.findById(teacherUsername);
//		Teacher teacher=tempTeacher.get();
//		
//		return new User(teacher.getTeacherUsername(),teacher.getTeacherPassword(),new ArrayList<>());
//		}
//		catch(UsernameNotFoundException unf)
//		{
//			unf.printStackTrace();
//		}
//		return null;
		
		
	}

	public TeacherRepository getTeacherRepository() {
		return teacherRepository;
	}

	public void setTeacherRepository(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	

}
