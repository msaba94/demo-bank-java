package com.bank_project.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bank_project.demo.model.User;

@Mapper
public interface BankMapper {

	User getUserByEmail(@Param("emailId") String emailId);

	void addUser(User user);

}
