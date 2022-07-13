package com.mmit;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/servlet_1"})
public class Servlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		var username = req.getParameter("Uname");
//		var password = req.getParameter("Upass");
		//input other resource using forward
		//getServletContext().getRequestDispatcher("/servlet_2").forward(req, resp);
		
		//input other resource using redirect
		resp.sendRedirect(req.getContextPath() + "/servlet_2");
	}
	
}
