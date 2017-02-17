package com.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.cpi.entity.User;
import com.cpi.service.Service;

public class ServiceImpl implements Service {

	@Override
	public User getUser(HttpServletRequest request) {
		String name = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		
		User user = new User(name, age, address);
		
		return user;
	}

}
