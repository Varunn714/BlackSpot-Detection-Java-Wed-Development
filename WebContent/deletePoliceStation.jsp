<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.dbconnection.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<body>

<%
	Connection con = DbConnection.connect();
	
	try{
		int id = Integer.parseInt(request.getParameter("id"));
		
		PreparedStatement ps = con.prepareStatement("delete from police_station where id=?");
		ps.setInt(1, id);
		
		int i = ps.executeUpdate();
		
		if(i>0){ %>
			<script type="text/javascript">
	        alert("Deleted Sucessfully!");
	    	</script>
			<%
			response.sendRedirect("viewPoliceStation.jsp");
			
		}else{
			%>
			
			<script type="text/javascript">
	        alert("Not deleted!")
	    	</script>
		<%
			
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	

%>

</body>

