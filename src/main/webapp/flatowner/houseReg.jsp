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
                   <div class="form-group row">
                            <label for="inputfirstName" class="col-sm-3 col-form-label">First Name</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="firstName" id="inputfirstName"
                                       placeholder="First Name" >
                            </div>
                        </div>
                         <div class="form-group row">
                            <label for="inputlastName" class="col-sm-3 col-form-label">Last Name</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="lastName" id="inputlastName"
                                       placeholder="Last Name">
                            </div>
                        </div>
                      <div class="form-group row">
                            <label for="inputPhone3" class="col-sm-3 col-form-label">Phone No</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control" name="phoneno" id="inputPhone3"
                                       placeholder="Phone No">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="inputEmail3" class="col-sm-3 col-form-label">Email</label>
                            <div class="col-sm-9">
                                <input type="email" class="form-control" name="email" id="inputEmail3"
                                       placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="inputPassword3" class="col-sm-3 col-form-label">Password</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" name="password" id="inputPassword3"
                                       placeholder="Password">
                            </div>
                        </div>


                        <div class="form-group row">
                            <div class="col-sm-12">
                                <button type="submit" name="operationType" value="reg" class="btn btn-success btn-block">Create Account</button>
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
