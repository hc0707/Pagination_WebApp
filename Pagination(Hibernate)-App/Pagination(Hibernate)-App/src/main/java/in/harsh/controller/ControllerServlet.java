package in.harsh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import in.harsh.dto.FlowersDto;
import in.harsh.model.Flowers;
import in.harsh.service.IFlowersService;
import in.harsh.servicefactory.FlowersServiceFactory;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IFlowersService getFlowersService = FlowersServiceFactory.getBankAccountService();
		HttpSession session = request.getSession(true);
		String targetPage = null;
		Long totalRecords;
		Integer recordSize;
		Long noOfPages;
		String pageString = request.getParameter("pageNumber");
		Integer pageNumber=1;
		RequestDispatcher dispatcher;
		//request coming from jsp page
		try {
		if (pageString != null) {
			pageNumber = Integer.parseInt(pageString);
			totalRecords=(Long) session.getAttribute("totalRecords");
			recordSize=(Integer) session.getAttribute("recordSize");
			noOfPages=(Long) session.getAttribute("noOfPages");
			
		} 
		//request coming from index.html
		else {
			pageNumber = 1;
			totalRecords = getFlowersService.getNumberOfRecords();
			session.setAttribute("totalRecords", totalRecords);
			recordSize = Integer.parseInt(request.getParameter("recordSize"));
			session.setAttribute("recordSize", recordSize);
			noOfPages = totalRecords / recordSize;
			if (totalRecords % recordSize != 0) {
				noOfPages++;
			}
			session.setAttribute("noOfPages", noOfPages);
		}
		request.setAttribute("pageNumber", pageNumber);
		
		if (getFlowersService != null) {
			List<FlowersDto> accounts = getFlowersService.getRecord(recordSize, pageNumber);
			request.setAttribute("records", accounts);
		}	
		targetPage="/viewAll.jsp";
		}catch (HibernateException he) {
			he.printStackTrace();
			targetPage="/error.jsp";
		}
		catch (Exception e) {
			e.printStackTrace();
			targetPage="/error.jsp";
		}
		dispatcher = request.getRequestDispatcher(targetPage);

			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
}
