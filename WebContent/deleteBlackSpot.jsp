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
		int spot_id = Integer.parseInt(request.getParameter("spot_id"));
		
		PreparedStatement ps = con.prepareStatement("delete from blackspot_details where spot_id=?");
		ps.setInt(1, spot_id);
		
		int i = ps.executeUpdate();
		
		if(i>0){ %>
			<script type="text/javascript">
	        alert("Deleted Sucessfully!");
	    	</script>
			<%
			response.sendRedirect("viewPBlackSpots.jsp");
			
		}else{
			%>
			response.sendRedirect("viewPBlackSpots.jsp");
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