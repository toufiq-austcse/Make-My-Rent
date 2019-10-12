package controllers;

import java.io.IOException;
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
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import models.House;
import models.Owner;
import models.Rent;

@WebServlet("/house")
public class HouseController extends HttpServlet{
	private HouseManager aHouseManager = new HouseManager();
	private RentManager aRentManager = new RentManager();
	private OwnerManager aOwnerManager = new OwnerManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameterMap().containsKey("req")) {
			String path = req.getParameter("req").toString().trim();
			
			if(path.equals("addhouse")) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("flatowner/houseReg.jsp");
				requestDispatcher.forward(req, resp);
			}else if(path.equals("managehouse")) {
				HttpSession session = req.getSession();
				Owner owner = this.aOwnerManager.getOwner((Owner)session.getAttribute("owner"));
				ArrayList<House> houses = this.aHouseManager.getAllHouse(owner.getOwnerId());
			
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("flatowner/managehouse.jsp");
				req.setAttribute("houses", houses);
				requestDispatcher.forward(req, resp);
			}else if(path.equals("edit")) {
				int houseId = Integer.parseInt(req.getParameter("hid").toString().trim());
				
			}else if(path.equals("rent")) {
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("flatowner/rent.jsp");
		
				requestDispatcher.forward(req, resp);
			}else if(path.equals("getflat")) {
				String hid = req.getParameter("hid");
				ArrayList<Rent> allRents = this.aRentManager.getAllRents(Integer.parseInt(hid));
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("flatowner/managerents.jsp");
				req.setAttribute("rents", allRents);
				requestDispatcher.forward(req, resp);
			}
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operationName = req.getParameter("operationType");
		if(operationName.equals("addhouse")) {
			int ownerId = Integer.parseInt(req.getParameter("ownerId"));
			String district = req.getParameter("district");
			String region = req.getParameter("region");
			String houseAddress = req.getParameter("houseAddress");
			House aHouse = new House(district, region, houseAddress, ownerId);
			if(this.aHouseManager.insertHouse(aHouse)) {
				HttpSession session = req.getSession();
				Owner owner = this.aOwnerManager.getOwner((Owner)session.getAttribute("owner"));
				ArrayList<House> houses = this.aHouseManager.getAllHouse(owner.getOwnerId());
			
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("flatowner/managehouse.jsp");
				req.setAttribute("houses", houses);
				requestDispatcher.forward(req, resp);
			}
			
		}
		
		
	}
	
}
