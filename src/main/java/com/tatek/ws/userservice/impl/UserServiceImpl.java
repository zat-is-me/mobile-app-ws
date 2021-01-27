package com.tatek.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatek.ws.shared.Utils;
import com.tatek.ws.ui.model.request.UserDetailsRequestModel;
import com.tatek.ws.ui.model.response.UserRest;
import com.tatek.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	// Temporary storage
	Map<String, UserRest> users;
	
	Utils utils;
	
	public UserServiceImpl() {
	}
	
	//Constructor Injection
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}

	@Override
	public UserRest creatUser(UserDetailsRequestModel userDetails) {
		
		UserRest returnValue = new UserRest();
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());

		String userId = utils.generateUserId();
		returnValue.setUserId(userId);

		if (users == null) 
			users = new HashMap<>();
		users.put(userId, returnValue);
		
	  return returnValue;
	}

}
