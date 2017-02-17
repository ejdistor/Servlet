package com.cpi.service;

import javax.servlet.http.HttpServletRequest;

import com.cpi.entity.User;

public interface Service {

	User getUser(HttpServletRequest request);
	
}
