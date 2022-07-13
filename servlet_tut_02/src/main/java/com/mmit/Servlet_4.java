package com.mmit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/servlet_4"})
public class Servlet_4 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var username = req.getParameter("Uname");
		var password = req.getParameter("Upass");
		PrintWriter out = resp.getWriter();
		if(username.equals("jeon") && password.equals("123")) {
			out.write("<h4> <font color = 'purple'>Log in success</h4>");
		} else {
			out.write("<h4><font color = 'red'>Authentication Problem</font></h4>");
		}
	}

}
