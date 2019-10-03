<%@page import="models.Owner"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner Login</title>

<%@include file="head.jsp"  %>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");

if(session.getAttribute("owner")!= null){
	response.sendRedirect("dashboard.jsp");
}

%>
 <div class="container" style="margin-top: 200px">
    <div class="row">
        <div class="col-sm-6 m-xl-auto">
            <div class="card">
                <div class="card-body">
                    <h3 class="text-center">
						Owner Login
                    </h3>
                    <form action="<%=request.getContextPath() %>/owner" method="post">
                    	
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
                                <button type="submit" name="operationType" value="login" class="btn btn-success btn-block">Sign in</button>
                            </div>
                        </div>
                        <div class="form-group row">
                        <div class="offset-6">
                        </div>
                          <div>
                            <a href="register.jsp">Don't have an account?</button>
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
</html>