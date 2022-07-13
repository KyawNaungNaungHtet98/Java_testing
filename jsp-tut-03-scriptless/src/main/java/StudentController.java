

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mmit.init.Batch;
import com.mmit.init.Student;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/student", "/student-add","/add-student"})
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext context = config.getServletContext();
		List<Batch> list = (ArrayList<Batch>) context.getAttribute("batches");
		if (list == null) {
			list = new ArrayList<Batch>();
		}
		list.add(new Batch("Batch1", LocalDate.parse("2022-07-12")));
		list.add(new Batch("Batch2", LocalDate.parse("2022-08-01")));
		context.setAttribute("batches", list);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		String title_value = "";
		String page_name = "";
		if ("/student".equals(action)) {
			title_value = "Student";
			page_name = "/student.jsp";
		} else if ("/student-add".equals(action)) {
			title_value = "Student|Add";
			page_name = "/student-add.jsp";
		}
		req.setAttribute("title", title_value);
		getServletContext().getRequestDispatcher(page_name).forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("stdName");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String batch = req.getParameter("batch");
		String old_std = req.getParameter("old");
		
		Student new_student = new Student();
		new_student.setName(name);
		new_student.setPhone(phone);
		new_student.setEmail(email);
		new_student.setOld_student(old_std == null ? false : true);
		new_student.setRegisterDate(LocalDate.now());
		new_student.setBatch(batch);
		
		HttpSession session = req.getSession(true);
		
		List<Student> list = (ArrayList<Student>)session.getAttribute("students");
		if(list == null) {
			list = new ArrayList<Student>();
		}
		list.add(new_student);
		
		session.setAttribute("students", list);
		
		resp.sendRedirect(req.getContextPath()+"/student");
	}
}
