package mmit.z2p.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mmit.z2p.model.entity.Batch;
import mmit.z2p.service.BatchSerive;
import mmit.z2p.service.LevelService;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
@WebServlet(urlPatterns = {"/batches" , "/add-batch"})
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BatchSerive batchService;
	private LevelService levelService;
	@Override
	public void init() throws ServletException {
		super.init();
		EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf_obj == null) {
			emf_obj = Persistence.createEntityManagerFactory("z2p");
			getServletContext().setAttribute("emf", emf_obj);
			} 
		batchService = new BatchSerive(emf_obj.createEntityManager());
		levelService = new LevelService(emf_obj.createEntityManager());
	}
	@Override
	public void destroy() {
		EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf_obj != null && emf_obj.isOpen()) {
			emf_obj.close();
		}
		super.destroy();
	}
	public BatchController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var action = request.getServletPath();
		if("/batches".equals(action)) {
			goHomePage(request,response);
		} 
		else if("/add-batch".equals(action)) {
			goAddPage(request,response);
		}
	}

	private void goAddPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var obj = new Batch();
		var list = levelService.findAll();
		request.setAttribute("title", "Batch");
		request.setAttribute("batch", obj);
		request.setAttribute("level", list);
		getServletContext().getRequestDispatcher("/batch-add.jsp").forward(request, response);
		
	}
	private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var levelId = request.getParameter("levelId");
		
		
		var list = (levelId == null) ? batchService.findAll() : batchService.findByLevelId(Integer.parseInt(levelId));
		
		request.setAttribute("title", "Batch");
		request.setAttribute("batches", list);
		getServletContext().getRequestDispatcher("/batch-home.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var id = request.getParameter("batchId");
		var batch = "0".equals(id) ? new Batch() : batchService.findById(Integer.parseInt(id));
		batch.setLevel(levelService.findById(Integer.parseInt(request.getParameter("level"))));
		batch.setName(request.getParameter("name"));
		batch.setStartDate(LocalDate.parse(request.getParameter("startDate")));
		
		// save to db
		batchService.save(batch);
		// redirect page
		response.sendRedirect(request.getContextPath().concat("/batches"));
	}

}
