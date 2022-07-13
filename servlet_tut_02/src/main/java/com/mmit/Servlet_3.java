package com.mmit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/servlet_3"})
public class Servlet_3 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		var name = req.getParameter("Uname");
		var password = req.getParameter("Upass");
		out.write("<html>");
		out.write("<body>");
		out.write("<h3>Servlet 3</h3>");
		out.print("<h5>Username : "+ name +"</h5>" );
		out.print("<h5>Password : "+ password+"</h5>" );
		out.print("<hr>");
		getServletContext().getRequestDispatcher("/servlet_4").include(req, resp);
		out.write("</body></html>");
	}

}
