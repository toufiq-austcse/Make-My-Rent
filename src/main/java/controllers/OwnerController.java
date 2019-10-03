package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.OwnerManager;
import models.Owner;
import security.PasswordHash;

@WebServlet("/owner")
public class OwnerController extends HttpServlet {
	private OwnerManager ownerManager = new OwnerManager();
	private PasswordHash passwordHash = new PasswordHash();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operationType = request.getParameter("operationType");
		PrintWriter out = response.getWriter();
		if(operationType.equals("reg")) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String phoneNumber = request.getParameter("phoneno");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			Owner owner = new Owner(email, phoneNumber, password, firstName, lastName);
			
			try {
				if(this.ownerManager.insertOwner(owner)) {
					HttpSession session = request.getSession();
					owner.setPassword(null);
					session.setAttribute("owner", owner);
					response.sendRedirect("flatowner/dashboard.jsp");
				}else {
					out.println("Registration Error!");
				}
			}catch (Exception e) {
				out.println("Registration Error!");
				
			}
			
		}else if(operationType.equals("login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Owner owner = this.ownerManager.getOwner(new Owner(email, null, password, null, null));
	
			if(owner != null && this.passwordHash.verifyPassword(password, owner.getPassword()) ) {
				HttpSession session = request.getSession();
				owner.setPassword(null);
				session.setAttribute("owner", owner);
				response.sendRedirect("flatowner/dashboard.jsp");
			}else {
				out.println("Login Error!");
			}
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("logout").toString().trim().equals("true")) {
			HttpSession session = request.getSession();
			session.invalidate();  
			response.sendRedirect("index.jsp");
		}
	}
	
	
	
	

}
