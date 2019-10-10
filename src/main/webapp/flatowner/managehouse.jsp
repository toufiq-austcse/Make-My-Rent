<%@page import="models.House"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="models.Owner"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
if(session.getAttribute("owner")==null){
	RequestDispatcher dd = request.getRequestDispatcher("login.jsp");
	 dd.forward(request, response);	
}else{
	ArrayList<House> houses = (ArrayList<House>)request.getAttribute("houses");
	%>
	<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <%@include file="head.jsp"  %>
<title>Manage Your Houses</title>
</head>
<body>
<script>
	function deleteHouse(id) {
		console.log(id);
	}
</script>
 <%@include file="header.jsp"  %>
 <body>
   <div class="container" style="margin-top:25px">
   <div style="text-align: center;">
  <h4>Your Houses</h4>
   </div>
    <div class="row">
      <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">District</th>
      <th scope="col">Region</th>
      <th scope="col">Address</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <%for(int i=0;i<houses.size();i++){%>
	  <tr>
      <th scope="row"><%= i+1 %></th>
      <td><%= houses.get(i).getDistrict() %></td>
      <td><%= houses.get(i).getRegion() %></td>
      <td><%= houses.get(i).getHouseAddress() %></td>
      <td>
      	<a style="color:white" class="btn btn-info" href="<%=request.getContextPath() %>/house?req=rent">Rent Flat</a>
      	<a style="color:white" class="btn btn-danger" onclick="deleteHouse(<%=houses.get(i).getHouseId() %>)">Delete</a>
      </td>
    </tr>
	  <%
  } %>
   
   

  </tbody>
</table>
    </div>
</div>
 <%@include file="scripts.jsp"  %>
  </body>
</body>
</html>
	<%
	
	
}

%>
