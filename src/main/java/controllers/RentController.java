package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

@WebServlet("/rent")
public class RentController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletFileUpload myServletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
		PrintWriter out = res.getWriter();
		if(myServletFileUpload.isMultipartContent(req)){
			List<FileItem> myfiles;
			try {
				myfiles = myServletFileUpload.parseRequest(new ServletRequestContext(req));
				for(int i=0;i<myfiles.size();i++) {
					System.out.println(myfiles.get(i).getFieldName());
					System.out.println(myfiles.get(i).getString());
				}
			}catch (Exception e) {
				out.println("File Upload Exception");
				e.printStackTrace();
			}
			
		}
	}
	
}
