package com.jspiders.cardekhowithservlet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.cardekhowithservlet.jdbc.CarJDBC;
@WebServlet("/updateCar")
public class UpdateCar extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oldName = req.getParameter("oldname");
		String newName = req.getParameter("newname");
		int res= CarJDBC.updateCar(oldName,newName);
		if(res>=1) {
			req.setAttribute("mesg", res +" Car Updated");
		}else {
			req.setAttribute("mesg", " Car Not Updated");
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("UpdateCar.jsp");
		requestDispatcher .forward(req,resp);
	}

}
