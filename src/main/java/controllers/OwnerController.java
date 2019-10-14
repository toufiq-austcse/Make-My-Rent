package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.HouseManager;
import bll.OwnerManager;
import bll.RentManager;
import models.House;
import models.Owner;
import models.Rent;
import security.PasswordHash;

@WebServlet("/owner")
public class OwnerController extends HttpServlet {
	private OwnerManager ownerManager = new OwnerManager();
	private PasswordHash passwordHash = new PasswordHash();
	private RentManager rentManager = new RentManager();
	private HouseManager aHouseManager = new HouseManager();
	
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
					Owner aOwner =  this.ownerManager.getOwner(owner);
					session.setAttribute("owner",aOwner);
					ArrayList<House> houses = this.aHouseManager.getAllHouse(aOwner.getOwnerId());
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("flatowner/managehouse.jsp");
					request.setAttribute("houses", houses);
					requestDispatcher.forward(request, response);
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
				Owner aowner = this.ownerManager.getOwner((Owner)session.getAttribute("owner"));
				ArrayList<House> houses = this.aHouseManager.getAllHouse(aowner.getOwnerId());
			
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("flatowner/managehouse.jsp");
				request.setAttribute("houses", houses);
				requestDispatcher.forward(request, response);
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
			ArrayList<Rent> allPublishedRents = this.rentManager.getAllRents();
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("allPublishedRents", allPublishedRents);
			rd.forward(request, response);
		}
	}
	
	
	
	

}
