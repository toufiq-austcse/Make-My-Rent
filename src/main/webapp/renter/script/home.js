/*axios.get('http://localhost:8080/MakeMyRent/home').
	then(response=>{
		console.log(response);
		let rents = response.data;
		let rentsHtml = '';

		rents.forEach(rent => {
			console.log(rent);
			rentsHtml += ` <div class="col-lg-3 col-md-6 mb-4">
			<div class="card h-100">
			  <img class="card-img-top" src="E:\\javawebprojects\\MakeMyRent\\src\\main\\webapp\\image\\featuredimages\\1570973530359.jpg" alt="">
			  <div class="card-body">
				<h4 class="card-title">Card title</h4>
				<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
			  </div>
			  <div class="card-footer">
				<a href="#" class="btn btn-primary">Find Out More!</a>
			  </div>
			</div>
		  </div>`
		});
		document.getElementById('rents').innerHTML +=rentsHtml
	})*/