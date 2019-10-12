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
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
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
	
	private String uploadFile(FileItem aFile,String uploadPath) throws Exception {

		// String uploadPath = getServletContext().getRealPath("") + "blogimg\\";
		
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		
		/*File myFile = new File(uploadPath + aFile.getName());*/
		String fileName = aFile.getName();
		String ex = getExtension(fileName);
	
		if(isValidExtension(fileName)) {
			aFile.write(new File(uploadPath +System.currentTimeMillis()+ex ));
			return uploadPath +System.currentTimeMillis()+ex;
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
