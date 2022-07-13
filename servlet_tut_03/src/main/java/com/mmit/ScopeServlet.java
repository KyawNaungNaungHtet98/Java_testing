package com.mmit;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/scopes"})
public class ScopeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//application scope or context scope
		ServletContext context = getServletConfig().getServletContext();
		context.setAttribute("contextScope", "This is context Scope");
		// session scope
		HttpSession session = req.getSession(true);
		session.setAttribute("sessionScope", "This is Session Scope");
		//request scope
		req.setAttribute("requestScope", "This is Request Scope");
		
		getServletContext().getRequestDispatcher("/display.jsp").forward(req, resp);
	}
}
