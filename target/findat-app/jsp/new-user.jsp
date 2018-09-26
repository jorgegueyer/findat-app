<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		 <link rel="stylesheet" href="../css/bootstrap.min.css"/>         
       	<script src="../js/bootstrap.min.js"></script>   
		<title>New User</title>
	</head>
	<body>
		<div class="container">
	            <form action="/user" method="post"  role="form" data-toggle="validator" >
	                <c:if test ="${empty action}">                        	
	                    <c:set var="action" value="add"/>
	                </c:if>
	                <input type="hidden" id="action" name="action" value="${action}">
	                <input type="hidden" id="idUser" name="idUser" value="${user.id}">
	                <h2>User</h2>
	                <div class="form-group col-xs-4">
	                	<label for="username" class="control-label col-xs-4">User Name:</label>
	                    <input type="text" name="username" id="username" class="form-control" value="${user.username}" required="true" />
	                    
	                    <label for="name" class="control-label col-xs-4">Name:</label>
	                    <input type="text" name="name" id="name" class="form-control" value="${user.name}" required="true" />                                   
	
	                    <label for="lastName" class="control-label col-xs-4">Last name:</label>                   
	                    <input type="text" name="lastName" id="lastName" class="form-control" value="${user.lastName}" required="true"/> 
	
	                    <label for="nif" class="control-label col-xs-4">Nif</label>                 
	                    <input type="text"  pattern="^\d{8}\w{1}$" name="nif" id="nif" class="form-control" value="${user.nif}" maxlength="9"  required="true"/>
	
	                    <label for="email" class="control-label col-xs-4">E-mail:</label>                   
	                    <input type="text" name="email" id="email" class="form-control" value="${user.email}" placeholder="user@findat.com" required="true"/>
	
	                    <br></br>
	                    <button type="submit" class="btn btn-primary  btn-md">Accept</button> 
	                </div>                                                      
	            </form>
	        </div>
	</body>
</html>