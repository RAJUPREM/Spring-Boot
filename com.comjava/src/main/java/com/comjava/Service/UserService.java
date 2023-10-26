package com.comjava.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Service;

import com.comjava.Entity.User;
import com.comjava.Reposiotry.UserRepository;

@Service
public class UserService {
	
@Autowired
private UserRepository userRepository;

public String addUser(User user) {
	
List<User> allUsers = userRepository.findAll();

double limit;

	if (allUsers.size() < 3) 
	{ 
		limit = 1500;
	} 
	else if (allUsers.size() < 7) 
	{ 
		limit = 2000;
	} 
	else {
		limit = 2500;
	}
	
if (user.getAmount() > limit) {
return "Error: Amount exceeds the limit.";
}

userRepository.save(user);

return "User added successfully."; 
}
}