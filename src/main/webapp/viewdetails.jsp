<%@page import="models.Rent"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="ISO-8859-1">
  <%@include file="head.jsp"  %>
<title>View Details</title>

</head>

</head>

<body>

  <!-- Navigation -->
 <%@include file="header.jsp"  %>

  <!-- Page Content -->
  <div class="container"> 
  <%
  	Rent aRent = (Rent) request.getAttribute("aRent");
  %>
	<%
		String featuredImageUrl = request.getContextPath()+"/image/"+aRent.getFeaturedPhotos().replace(";", "")+"?type=featured";
	%>
    <!-- Jumbotron Header -->
    <header class="jumbotron my-4"  style=" height: 368px;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;background-image: url('<%= featuredImageUrl%>');">
     
    </header>
    <div style="text-align: center;">
    	<h4 >Rent's Details</h4>
    </div>
    <!-- Page Features -->
    <div class="row text-center" id='rents'>
   
   	<table class="table table-bordered">
   
   		<tr>
   			<td>Rent ID</td>
   			<td> <%=aRent.getRentId() %></td>
   			
   		</tr>
   		<tr>
   			<td>District</td>
   			<td> <%=aRent.getHouse().getDistrict() %></td>
   			
   		</tr>
   		<tr>
   			<td>Region</td>
   			<td> <%=aRent.getHouse().getRegion() %></td>
   			
   		</tr>
   		<tr>
   			<td>Address</td>
   			<td> <%=aRent.getHouse().getHouseAddress() %></td>
   			
   		</tr>
   		<tr>
   			<td>Rent</td>
   			<td> <%=aRent.getRentPerMonth() %>/-</td>
   			
   		</tr>
   		<tr>
   			<td>Advance Payment</td>
   			<td> <%=aRent.getAdvance() %>/-</td>
   			
   		</tr>
   		<tr>
   			<td>Extras</td>
   			<td> <%=aRent.getExtras() %></td>
   			
   		</tr>
   		<tr>
   			<td>Posted On</td>
   			<td> <%=aRent.getCreatedAt() %></td>
   			
   		</tr>
   		 <%
    	String[] images = aRent.getPhotos().split(";");
    %>
		<table class="table">
		<tr >
		<%
		
			for (String link :images){
				String imageLink = request.getContextPath()+"/image/"+link+"?type=flat";
				%>
					<td>
						<img alt="" src="<%=imageLink%>" style="width:70%">
					</td>
				
				<%
			}
		%>
		</tr>
		</table>
   	</table>
			<table class="table table-bordered">
   		<tr>
   			<td>Owner Email</td>
   			<td> <%=aRent.getaOwner().getEmail() %></td>
   			
   		</tr>
   		<tr>
   			<td>Phone Number</td>
   			<td> <%=aRent.getaOwner().getPhoneNumber() %></td>
   			
   		</tr>
   		
   		
   	</table>	
     

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <%@include file="footer.jsp"  %>

  <!-- Bootstrap core JavaScript -->  

 

</body>

</html>
