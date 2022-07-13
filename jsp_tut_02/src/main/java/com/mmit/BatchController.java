package com.mmit;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mmit.init.Batch;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/batch" , "/batch-add"})
public class BatchController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		String page_name = "";
		if ("/batch".equals(action)) {
			page_name = "/batch.jsp";
		} else if ("/batch-add".equals(action)) {
			page_name = "/batch.jsp";
		}
		getServletContext().getRequestDispatcher(page_name).forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("batch");
		String date = req.getParameter("date");
		
		Batch b = new Batch();
		b.setName(name);
		b.setStart_date(LocalDate.parse(date));
		
		HttpSession session = req.getSession(true);
		
		List<Batch> list = (ArrayList<Batch>) session.getAttribute("batches");
		if(list == null) {
			list = new ArrayList<Batch>();
			
		}
		list.add(b);
		
		session.setAttribute("batches", list);
		
		resp.sendRedirect(req.getContextPath()+"/batch");
	}
}
