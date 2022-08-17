package mmit.z2p.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mmit.z2p.model.entity.Course;
import mmit.z2p.service.CourseService;
import mmit.z2p.service.LevelService;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
@WebServlet(urlPatterns = {"/courses", "/add-course","/edit-course","/delete-course"})
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private CourseService courseService;
	  private LevelService lvlSerice;
	    @Override
	    public void init(ServletConfig config) throws ServletException {
	    	super.init(config);
	    	EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
			if(emf_obj == null) {
				emf_obj = Persistence.createEntityManagerFactory("z2p");
				getServletContext().setAttribute("emf", emf_obj);
			}
			courseService = new CourseService(emf_obj.createEntityManager());
			lvlSerice = new LevelService(emf_obj.createEntityManager());
	    }
	    @Override
		public void destroy() {
			super.destroy();
			EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
			if(emf_obj != null && emf_obj.isOpen())
				emf_obj.close();
		}
	public CourseController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var action = request.getServletPath();
		if("/courses".equals(action)) {
			goHomePage(request, response);
		}
		else if("/add-course".equals(action) || "/edit-course".equals(action)) {
			goAddPage(request, response);
		}
		else if("/delete-course".equals(action)) {
			goDeleteCourse(request,response);
		}
	}

	private void goDeleteCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		var id = request.getParameter("id");
		
		//delete from db
		courseService.deleteById(Integer.parseInt(id));
		//redirect
		response.sendRedirect(request.getContextPath().concat("/courses"));
	}
	private void goAddPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		var courseId = request.getParameter("id");
		
		var obj = (courseId == null) ? new Course() : courseService.findById(Integer.parseInt(courseId));
		var list = lvlSerice.findAll();
		request.setAttribute("title", "Course");
		request.setAttribute("course", obj);
		request.setAttribute("levels", list);
		getServletContext().getRequestDispatcher("/course-add.jsp").forward(request, response);
		
	}
	private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var levelId = request.getParameter("levelId");
		
		var list = (levelId == null) ? courseService.findAll() : courseService.findByLevelId(Integer.parseInt(levelId));
		request.setAttribute("title", "Course");
		request.setAttribute("courses", list);
		getServletContext().getRequestDispatcher("/course-home.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var courseId = request.getParameter("courseId");
		var course = "0".equals(courseId) ? new Course() : courseService.findById(Integer.parseInt(courseId));
		//get data from request
		course.setContents(request.getParameter("outline"));
		course.setName(request.getParameter("name"));
		course.setLevel(lvlSerice.findById(Integer.parseInt(request.getParameter("level"))));
		
		courseService.save(course);
		
		response.sendRedirect(request.getContextPath().concat("/courses"));
		}

}
