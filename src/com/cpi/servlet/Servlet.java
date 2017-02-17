package com.cpi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cpi.entity.User;
import com.cpi.service.Service;
import com.service.impl.ServiceImpl;

public class Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		
		System.out.println("name "+name);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("pages/main.jsp");
		dispatcher.forward(request, response);
	}
	
	/*public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		String action = request.getParameter("action");
		String page = null;
		
		if(action.equals("goToMain")){
			page = "pages/main.jsp";
		}else{
			page = "pages/page1.jsp";
		}
		request.setAttribute("name", name);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}*/
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String page = "pages/main.jsp";
		
		Service service = new ServiceImpl();
		
		User user = service.getUser(request);
		
		request.setAttribute("userJsp", user);
		
		User getUser = (User) request.getAttribute("userJsp");
		
		String[] checked = request.getParameterValues("checked");
		for(int i = 0; i < checked.length; i++){
			System.out.println("check: "+checked[i]);
		}
		
		Enumeration e = request.getParameterNames();
		
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
		
		List<Map<String, Object>> l = new ArrayList<>();
		
		for(int i = 0 ; i < 10; i++){
			Map<String, Object> m = new HashMap<>();
			m.put("index", i);
			l.add(m);
		}
		
		System.out.println("List of map: "+l);
		request.setAttribute("object", l);
		
		page = "pages/index.jsp";
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}

