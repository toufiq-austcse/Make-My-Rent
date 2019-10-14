<%@page import="models.Rent"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="ISO-8859-1">
  <%@include file="head.jsp"  %>
<title>Make My Rent</title>

</head>

</head>

<body>

  <!-- Navigation -->
 <%@include file="header.jsp"  %>

  <!-- Page Content -->
  <div class="container"> 
    <!-- Jumbotron Header -->
    <header class="jumbotron my-4"  >
      <h1 class="display-3" style="text-align:center">A Warm Welcome!</h1>
      <form>
  <div class="row">
    <div class="col">
     <label for="district">District</label>
     <select id="district" name="district" onchange="onDistrictChange(this)" class="form-control" >
	     				<option value="Dhaka">Dhaka</option>
	     			</select>
    </div>
    <div class="col">
    <label for="region">Region</label>
      <select id="region" name="region" onchange="onRegionChange(this)" class="form-control">
     					 <option value="All">All</option>
	     				<option value="Gulshan">Gulshan</option>
	     				<option value="Banani">Banani</option>
	     				<option value="Tejgon">Tejgon</option>
	     			</select>
    </div>
  </div>
</form>

    
    </header>

    <!-- Page Features -->
    <div class="row text-center" id='rents'>
    
    

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
	
  <!-- Footer -->
  <%@include file="footer.jsp"  %>

  <!-- Bootstrap core JavaScript -->  

 <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript">
let allRents;
const url = "http://localhost:8080/MakeMyRent/home";
axios.get(url).then(response=>{
    allRents = response.data;
    console.log(allRents);
    appendRents(allRents)
	
});

function onDistrictChange(a){
	 var x = (a.value || a.options[a.selectedIndex].value);  //crossbrowser solution =)
	   
	    const result = allRents.filter(rent=>rent.house.district === x);
	    appendRents(result);
}
function onRegionChange(a) {
	 var x = (a.value || a.options[a.selectedIndex].value);  //crossbrowser solution =)
	   
		if(x === 'All'){
			console.log('sd ',allRents);
			appendRents(allRents);
		}else{
			 const result = allRents.filter(rent=>rent.house.region === x);
			    appendRents(result);
		}
		
	 
	    
}
function appendRents(allRents){
	console.log(allRents);
    let allrentsArea = document.getElementById('rents');
    allrentsArea.innerHTML ="";
    allRents.forEach(element => {
        allrentsArea.innerHTML += `<div class="col-lg-3 col-md-6 mb-4">
		<div class="card h-100">
		  <img class="card-img-top" src="/MakeMyRent/image/${element.featuredPhotos.substring(0, element.featuredPhotos.length - 1)}?type=featured" alt="">
		  <div class="card-body">
			<h4 class="card-title">Rent ${element.rentPerMonth}/-</h4>
			<p class="card-text"> ${element.house.houseAddress}</p>
			
		  </div>
		  <div class="card-footer">
			<a href="/MakeMyRent/rent?req=view&rid=${element.rentId}" class="btn btn-info">View Details</a>
		  </div>
		</div>
	  </div>`
    });
}
</script>
</body>

</html>
