package com.mmit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/servlet_2"})
public class Servlet_2 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write("<h3>Servlet 2</h3>");
		out.print("<h5>Username : "+ req.getParameter("Uname")+"</h5>" );
		out.print("<h5>Password : "+ req.getParameter("Upass")+"</h5>" );
		out.write("</body></html>");
	}

}
