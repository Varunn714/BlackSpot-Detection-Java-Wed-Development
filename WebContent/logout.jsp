<%@page import="com.credentials.Credentials"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%

if(Credentials.getRole() == "admin"){
	
	Credentials.setLoggedIn(false);
	Credentials.setRole("");

	response.sendRedirect("adminLogin.html");
	
}else if(Credentials.getRole() == "police"){
	
	Credentials.setLoggedIn(false);
	Credentials.setRole("");

	response.sendRedirect("policeLogin.html");
	
}else{
	Credentials.setLoggedIn(false);
	Credentials.setRole("");

	response.sendRedirect("userLogin.html");
	
}



%>