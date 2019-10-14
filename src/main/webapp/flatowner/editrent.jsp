<%@page import="models.Rent"%>
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
<title>View Rent</title>
</head>
<body>
 <%@include file="header.jsp"  %>
 <%
 	Rent aRent = (Rent)request.getAttribute("aRent");
 %>
 <body>
   <div class="container" style="margin-top: 50px">
    <div class="row">
        <div class="col-sm-10 m-xl-auto">
            <div class="card">
                <div class="card-body">
                    <h3 class="text-center">
					View Details
						
                    </h3>
                    <form action="<%=request.getContextPath() %>/rent?req=update" method="post">
                    <input type="hidden" id="rentId" name="rentId" value="<%= aRent.getRentId() %>">
                     <input type="hidden" id="houseId" name="houseId" value="<%= aRent.getHouseId() %>">
                   <div class="form-group row">
                            <label  class="col-sm-3 col-form-label"  >No of Rooms</label>
                            <div class="col-sm-9">
                              <input class="form-control" placeholder="No of Rooms" value="<%=aRent.getNoOfRooms() %>" type="number" name ="noOfRooms"required="required">
                            </div>
                        </div>
                         <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Extras</label>
                            <div class="col-sm-9">
                               <textarea class="form-control" name="extras"  rows="6" cols="6">
                               <%=aRent.getExtras() %></textarea>
                            </div>
                        </div>
                		<div class="form-group row">
                            <label class="col-sm-3 col-form-label"  >Rent/Month</label>
                            <div class="col-sm-9">
                              <input class="form-control" value="<%=aRent.getRentPerMonth() %>" name="rent" placeholder="Rent/Month" type="number" required="required">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label  class="col-sm-3 col-form-label"  >Advance</label>
                            <div class="col-sm-9">
                              <input class="form-control" name="advance" value="<%=aRent.getAdvance()%>" placeholder="Advance Payment Amount" type="number" required="required">
                            </div>
                        </div>
                          <div class="form-group row">
                            
                        </div>
                        <div class="form-group row">
                            <label  class="col-sm-3 col-form-label"  >Status</label>
                            <div class="col-sm-9">
                             	<label class="radio-inline"><input type="radio" name="status" value="1" <%=aRent.isIspublish()?"checked":""%>>Published</label>
								<label class="radio-inline"><input type="radio" name="status" value="0" <%=aRent.isIspublish()?"":"checked"%>>Unpublished</label>
                            </div>
                        </div>
                       
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <button type="submit" name="operationType" value="addhouse" class="btn btn-success btn-block">Update</button>
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
