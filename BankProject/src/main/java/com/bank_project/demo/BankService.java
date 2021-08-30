package com.bank_project.demo;

import org.springframework.stereotype.Service;

import com.bank_project.demo.model.User;

@Service
public interface BankService {

	User login(User user) throws Throwable;

	User register(User user) throws Throwable;

}
