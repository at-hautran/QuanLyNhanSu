<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/mycss.css">
<link rel="stylesheet" href="css/user.css">
<title>USER</title>
</head>
<body>
<div id="header">
		<div style="width: 100%"> 
         <h1>TRƯỜNG ĐẠI HỌC BÁCH KHOA - ĐẠI HỌC ĐÀ NẴNG</h1>
         </div>  
              </div>

<div class="nav-side-menu">
    <div class="brand">*^_^* MENU *^_^*</div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">
                <li>
                  <a href="#">
                  <i class="fa fa-dashboard fa-lg"></i> Information
                  </a>
                </li>
                  
               
                <li>
                <a href="#">
                <i class="fa fa-user fa-lg"></i> Edit </a>
                </li>
                
               <li>
                  <a href="#">
                  <i class="fa fa-user fa-lg"></i> Search
                  </a>
                  </li>

                 <li>
                  <a href="#">
                  <i class="fa fa-users fa-lg"></i> Logout
                  </a>
                </li>
            </ul>
     </div>
</div>
<div id="content" style = "margin: 50px 50px 00px 350px;">
<center><h3>MY INFORMATION</h3></center></br>
	<label for="name">My name</label>: <input type="text" id="name" name="name" size="80" /></br>
	<label for="email">Birthday</label>: <input type="text" id="birthday" name="birthday" size="80" /></br>
	<label for="email">Department</label>: <input type="text" id="faculty" name="f" size="80" /></br>
	<label for="email">Workdays</label>: <input type="text" id="lessons" name="lessons" size="80" /></br>
	<label for="email">CoefficientSalary</label>: <input type="text" id="coefficientSalary" name="coefficientSalary" size="80" /></br>
	<label for="email">Position</label>: <input type="text" id="degree" name="degree" size="80" /></br>
	<label for="email">Country</label>: <input type="text" id="country" name="country" size="80" /></br>
	<label for="email">Allowance</label>: <input type="text" id="allowance" name="allowance" size="80" /></br>
	<label for="email">Salary</label>: <input type="text" id="salary" name="salary" size="80" />

</div>


</body>
</html>