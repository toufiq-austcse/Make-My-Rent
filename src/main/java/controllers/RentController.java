package controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bll.RentManager;
import models.Rent;

 


@WebServlet("/rent")
public class RentController extends HttpServlet{
	private RentManager aRentManager = new RentManager();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		if(req.getParameterMap().containsKey("req")) {
			String path = req.getParameter("req").toString().trim();
			if(path.equals("view")) {
				int rentId = Integer.parseInt(req.getParameter("rid").toString().trim());
				
				this.aRentManager.isUpdatedImpression(rentId);
				Rent aRent = this.aRentManager.getAPublishedRent(rentId);
			
				RequestDispatcher aDispatcher = req.getRequestDispatcher("viewdetails.jsp");
				req.setAttribute("aRent", aRent);
				aDispatcher.forward(req, resp);
			}else if(path.equals("edit")) {
				int rentId = Integer.parseInt(req.getParameter("rid").toString().trim());
				Rent aRent = this.aRentManager.getARent(rentId);
				
			
				RequestDispatcher aDispatcher = req.getRequestDispatcher("flatowner/editrent.jsp");
				req.setAttribute("aRent", aRent);
				aDispatcher.forward(req, resp);
			}else if(path.equals("delete")) {
				if(this.aRentManager.isDeleted( Integer.parseInt(req.getParameter("rid").toString().trim()))) {
					resp.sendRedirect(req.getContextPath()+"/house?req=getflat&hid="+req.getParameter("hid").toString().trim());
				}else {
					PrintWriter out = resp.getWriter();
					out.print("Not Deleted");
				}
			}
			
			
		
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getParameterMap().containsKey("req")) {
			String path = req.getParameter("req").toString().trim();
			if(path.equals("update")) {
				String rentId = req.getParameter("rentId");
				String houseId = req.getParameter("houseId");
				String noOfRooms = req.getParameter("noOfRooms");
				String extras = req.getParameter("extras");
				String rent = req.getParameter("rent");
				String advance = req.getParameter("advance");
				String status = req.getParameter("status");
				
				Rent aRent = new Rent();
				aRent.setRentId(Integer.parseInt(rentId));
				aRent.setNoOfRooms(noOfRooms);
				aRent.setExtras(extras);
				aRent.setRentPerMonth(rent);
				aRent.setAdvance(advance);
				if(status.equals("0")) {
					aRent.setIspublish(false);
				}else {
					aRent.setIspublish(true);
				}
				
				if(this.aRentManager.isUpdated(aRent)) {
				
				res.sendRedirect(req.getContextPath()+"/house?req=getflat&hid="+houseId);
				}else {
					PrintWriter out = res.getWriter();
					out.print("Not Updated");
				}
			}
		}else {
		
		String RENTIMAGEUPLOADPATH = "E://javawebprojects//MakeMyRent//src//main//webapp//resource//rentimages//";
		String FEATUREDIMAGEUPLOADPATH = "E://javawebprojects//MakeMyRent//src//main//webapp//resource//featuredimages//";
		
		
		PrintWriter out = res.getWriter();
		if(ServletFileUpload.isMultipartContent(req)) {
			try {
				String photosPath = "";
				String featuredPhotoPath = "";
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
				String houseId = multiparts.get(0).getString();
				String noOfRooms = multiparts.get(1).getString();
				String extras = multiparts.get(2).getString();
				String rent=  multiparts.get(3).getString();
				String advance = multiparts.get(4).getString();
				for(FileItem item: multiparts) {
					if(!item.isFormField()) {
						if((item.getFieldName().equals("photos"))){
							photosPath += this.uploadFile(item,RENTIMAGEUPLOADPATH)+";";
						}if((item.getFieldName().equals("featuredphoto"))){
							featuredPhotoPath += this.uploadFile(item,FEATUREDIMAGEUPLOADPATH) +";";
						}
						
					}
				}
				
				Rent aRent = new Rent(Integer.parseInt(houseId), noOfRooms, extras, rent, advance, photosPath, featuredPhotoPath, true);
				if(this.aRentManager.insertRent(aRent)) {
					ArrayList<Rent> allRents = this.aRentManager.getAllRents(Integer.parseInt(houseId));
					
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("flatowner/managerents.jsp");
					req.setAttribute("rents", allRents);
					
					requestDispatcher.forward(req, res);
				}else {
					out.println("Not Inserted");
				}
			}catch (Exception e) {
				out.println("File Upload Exception");
				e.printStackTrace();
			}
		}
		}
	}
	
	private String uploadFile(FileItem aFile,String uploadPath) throws Exception {

		// String uploadPath = getServletContext().getRealPath("") + "blogimg\\";
		
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		
		/*File myFile = new File(uploadPath + aFile.getName());*/
		String fileName = aFile.getName();
		String ex = getExtension(fileName);
	
		String currentTimeInMils = Long.toString(System.currentTimeMillis());
		if(isValidExtension(fileName)) {
			aFile.write(new File(uploadPath +currentTimeInMils+ex ));
			return currentTimeInMils+ex;
		}else {
			return null;
		}
		

	}

	private String getExtension(String name) {
		return name.substring(name.indexOf("."), name.length());
	}

	private boolean isValidExtension(String name) {
		String extension = getExtension(name).toLowerCase();

		if (extension.equals(".jpg") || extension.equals(".png")) {

			return true;
		}

		return false;
	}
	
}
