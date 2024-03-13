package com.jspiders.cardekhowithservlet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.cardekhowithservlet.jdbc.CarJDBC;

@WebServlet("/carAdd")
public class CarAdd extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String color=req.getParameter("color");
		double price=Double.parseDouble(req.getParameter("price"));
		
		
		int res= CarJDBC.addCar(id,name,color,price);
		if(res==1) {
			req.setAttribute("mesg", res +" Car Added");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddCar.jsp");
			requestDispatcher .forward(req,resp);
		}else {
			System.out.println("Car Not Added");
		}
	}

	

}
