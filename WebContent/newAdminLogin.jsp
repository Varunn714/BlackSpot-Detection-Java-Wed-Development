<%@page import="java.applet.AudioClip"%>
<%@page import="java.applet.Applet"%>
<%@page import="java.net.URL"%>
<%@page import="com.credentials.Credentials"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.dbconnection.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String email = request.getParameter("email");
String password = request.getParameter("password");


try {
	Connection con = DbConnection.connect();
	
	response.setContentType("text/plain");

    PrintWriter p = response.getWriter();
	
	PreparedStatement ps = con.prepareStatement("select * from adminauth where email = ? and pass=?");
	
	ps.setString(1, email);
	ps.setString(2, password);
	
	ResultSet rs = ps.executeQuery();
	
	if(rs.next()){
		
		Credentials.setLoggedIn(true);
		Credentials.setAdmin_id(rs.getInt(1));
		Credentials.setAdmin_name(rs.getString(2));
		Credentials.setRole("admin");
		
		try {
			URL url = new URL("file:C:/temp/beep-04.wav");
			AudioClip clip = Applet.newAudioClip(url);
			clip.play();
			Thread.sleep(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	      p.println("success");
		response.sendRedirect("adminLogin.html");
		
//		response.sendRedirect("adminDashboard.jsp");				
		
		
	}else{
		p.println("error");
		
//		response.sendRedirect("adminLogin.html");	
//		System.out.println("Ops! Invalid Credentials Please try again.");
	}
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}

%>

</body>
</html>