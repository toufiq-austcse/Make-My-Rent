<%@page import="models.Rent"%>
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
	ArrayList<Rent> rents = (ArrayList<Rent>)request.getAttribute("rents");
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
  <h4>Flat Under Rents</h4>
   </div>
    <div class="row">
      <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">No Of Rooms</th>
      <th scope="col">Per Month Rent</th>
      <th scope="col">Advance Amount</th>
      <th scope="col">Posted On</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <%for(int i=0;i<rents.size();i++){%>
	  <tr>
      <th scope="row"><%= i+1 %></th>
      <td><%= rents.get(i).getNoOfRooms() %></td>
      <td><%= rents.get(i).getRentPerMonth() %></td>
      <td><%= rents.get(i).getAdvance() %></td>
        <td><%= rents.get(i).getCreatedAt() %></td>
      <td>
      	<a style="color:white" class="btn btn-info" href="<%=request.getContextPath() %>/house?req=rent&hid=<%=rents.get(i).getHouseId()%>">View Details</a>
      
      	<a style="color:white" class="btn btn-danger" onclick="deleteHouse(<%=rents.get(i).getHouseId() %>)">Delete</a>
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
