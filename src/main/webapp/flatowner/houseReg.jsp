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
<title>Add House</title>
</head>
<body>
 <%@include file="header.jsp"  %>
 <body>
   <div class="container" style="margin-top: 200px">
    <div class="row">
        <div class="col-sm-6 m-xl-auto">
            <div class="card">
                <div class="card-body">
                    <h3 class="text-center">
						Register Your House Here
						
                    </h3>
                    <form action="<%=request.getContextPath() %>/house" method="post">
                    <input type="hidden" id="ownerId" name="ownerId" value="<%= owner.getOwnerId() %>">
                   <div class="form-group row">
                            <label for="inputfirstName" class="col-sm-3 col-form-label">Select District</label>
                            <div class="col-sm-9">
                              <select class="form-control" name="district">
                              	<option value ="Dhaka" name="district">Dhaka</option>
                              </select>
                            </div>
                        </div>
                         <div class="form-group row">
                            <label for="inputlastName" class="col-sm-3 col-form-label">Region</label>
                            <div class="col-sm-9">
                                <select class="form-control" name="region">
                              	<option value ="Gulshan" name="region">Gulshan</option>
                              	<option value ="Banani" name="region">Banani</option>
                              	<option value ="Tejgaon" name="region">Tejgaon</option>
                              </select>
                            </div>
                        </div>
                      <div class="form-group row">
                            <label for="inputPhone5" class="col-sm-3 col-form-label">HouseAddress</label>
                            <div class="col-sm-9">
                                <textArea type="text" class="form-control" name="houseAddress" id="inputPhone5"
                                       placeholder="House Address"></textArea>
                            </div>
                        </div>
                        
                       
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <button type="submit" name="operationType" value="addhouse" class="btn btn-success btn-block">Add Hosue</button>
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
