package com.jspiders.cardekhowithservlet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.cardekhowithservlet.jdbc.CarJDBC;

@WebServlet("/deleteCar")
public class DeleteCar extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int res= CarJDBC.deleteCar(name);
		if(res>=1) {
			req.setAttribute("mesg", res +" Car deleted");
		}else {
			req.setAttribute("mesg", " Car Not deleted");
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("DeleteCar.jsp");
		requestDispatcher .forward(req,resp);
	}

}
