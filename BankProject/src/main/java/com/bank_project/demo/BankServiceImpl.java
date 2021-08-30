package com.bank_project.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank_project.demo.mapper.BankMapper;
import com.bank_project.demo.model.User;

@Service("bankService")
public class BankServiceImpl implements BankService {
	
	@Autowired
	BankMapper bankMapper;

	@Override
	public User login(User user) throws Throwable {
		if (user.getEmailId().isEmpty()) {
			throw new Exception("Email Id is Empty");    
		}
		
		User dbUser = bankMapper.getUserByEmail(user.getEmailId());
		if (dbUser == null) {
			throw new Exception("Email Id is Not Found"); 
		}
		
		if (!dbUser.getPassword().equals(user.getPassword())) {
			throw new Exception("Password Missmatched");
		}
		
		return dbUser;
	}

	@Override
	public User register(User user) throws Throwable {
		if (user.getEmailId().isEmpty()) {
			throw new Exception("Email Id is Empty");    
		}
		
		if (user.getPassword().isEmpty()) {
			throw new Exception("Password is Empty");    
		}
		
		User dbUser = bankMapper.getUserByEmail(user.getEmailId());
		if (dbUser != null) {
			throw new Exception("Email already register, Try with another Email Id");    
		}
		
		bankMapper.addUser(user);
		return user;
	}

}
