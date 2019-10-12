<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="models.Owner"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
if(session.getAttribute("owner")==null){
	RequestDispatcher dd = request.getRequestDispatcher("login.jsp");
	 dd.forward(request, response);	
}else{
	%>
	<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <%@include file="head.jsp"  %>
<title>Post Rent</title>
</head>
<body>
 <%@include file="header.jsp"  %>
 <body>
   <div class="container" style="margin-top: 50px">
    <div class="row">
        <div class="col-sm-10 m-xl-auto">
            <div class="card">
                <div class="card-body">
                    <h3 class="text-center">
					Give Your Empty Flat In Rent
						
                    </h3>
                    <form action="<%=request.getContextPath() %>/rent" method="post" enctype="multipart/form-data">
                    <input type="hidden" id="houseId" name="houseId" value="<%= request.getParameter("hid") %>">
                   <div class="form-group row">
                            <label  class="col-sm-3 col-form-label"  >No of Rooms</label>
                            <div class="col-sm-9">
                              <input class="form-control" placeholder="No of Rooms" type="number" name ="noOfRooms"required="required">
                            </div>
                        </div>
                         <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Extras</label>
                            <div class="col-sm-9">
                               <textarea class="form-control" name="extras" rows="6" cols="6"></textarea>
                            </div>
                        </div>
                		<div class="form-group row">
                            <label class="col-sm-3 col-form-label"  >Rent/Month</label>
                            <div class="col-sm-9">
                              <input class="form-control" name="rent" placeholder="Rent/Month" type="number" required="required">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label  class="col-sm-3 col-form-label"  >Advance</label>
                            <div class="col-sm-9">
                              <input class="form-control" name="advance" placeholder="Advance Payment Amount" type="number" required="required">
                            </div>
                        </div>
                          <div class="form-group row">
                            <label class="col-sm-3 col-form-label"  >Upload Photos</label>
                           <input type="file" name="photos" multiple>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label"  >Upload Featured Photo</label>
                           <input type="file" name="featuredphoto">
                        </div>
                       
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <button type="submit" name="operationType" value="addhouse" class="btn btn-success btn-block">Post Rent</button>
                            </div>
                        </div>
                        
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
 <%@include file="scripts.jsp"  %>
  </body>
</body>
</html>
	<%
	
	
}

%>
