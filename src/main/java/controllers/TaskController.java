package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDao;
import models.Task;

/**
 * Servlet implementation class TaskController
 */
public class TaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("tid"));

		TaskDao taskDao = new TaskDao();
		Task task = taskDao.getTask(1);
		request.setAttribute("task", task);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("showtask.jsp");
		requestDispatcher.forward(request, response);
		
	}


}
