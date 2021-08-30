package com.bank_project.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank_project.demo.model.User;


@RestController
@RequestMapping(value = "/bank")
public class BankController {
	
	@Autowired
	BankService bankService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String login(HttpServletRequest request, HttpServletResponse httpResponse,
			@RequestBody User user) {
		JSONObject jsonObject = new JSONObject();
		try {
			
			user = bankService.login(user);
			jsonObject.put("success", true);
			jsonObject.put("user", user.toJSON());
			
		} catch (Exception e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.getMessage());
		} catch (Throwable e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.getMessage());
		}
		return jsonObject.toString();
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String register(HttpServletRequest request, HttpServletResponse httpResponse,
			@RequestBody User user) {
		JSONObject jsonObject = new JSONObject();
		try {
			
			user = bankService.register(user);
			jsonObject.put("success", true);
			jsonObject.put("user", user.toJSON());
			
		} catch (Exception e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.getMessage());
		} catch (Throwable e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.getMessage());
		}
		return jsonObject.toString();
	}

}
