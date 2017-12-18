<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 
<head>
	 
    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/users.js" />"></script>
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="load(0,0);">
 
        <input type="hidden" id="user_id">
        Name: <input type="text" id="name" name="user_name" required><br>
        Email: <input type="email" id="email" name="email"  placeholder="Enter your email"><br>
        User Level: <select id="level" name="level">
 					<option value="1">admin</option>
  					<option value="2" >manager</option>
  					<option value="3">driver</option>
  					<option value="4" selected>registered</option>
					</select><br>
        User Login: <input type="text" id="userlogin" name="user_login" required><br>
        Password: <input type="password" id="password" required="required" name="password"><br>
        <button onclick="submit();">Submit</button>
        <div class="result" id="result"></div>  <div class="total" id="total"> </div><div class="prevpage" id="prevpage"><a href='#' onclick= prevpage(15);> PrevPage </a> </div> <div class="nextpage" id="nextpage"><a href='#' onclick= nextpage(15);> Next </a></div> 
        <table id="table" border=1>
            <tr> <th> Name </th> <th> Email </th> <th> Level </th> <th> User Login </th> <th> Password </th> <th> Edit </th> <th> Delete </th> </tr>         
      
        </table>
                
</body>
</html>