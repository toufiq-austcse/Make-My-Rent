<!doctype html>

<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
   <%@include file="head.jsp"  %>
    <title>Owner Registration</title>
  </head>
  <body>
   <div class="container" style="margin-top: 200px">
    <div class="row">
        <div class="col-sm-6 m-xl-auto">
            <div class="card">
                <div class="card-body">
                    <h3 class="text-center">
						Owner Registration
                    </h3>
                    <form action="<%=request.getContextPath() %>/owner" method="post">
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
</html>