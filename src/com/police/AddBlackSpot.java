package com.police;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.credentials.Credentials;
import com.dbconnection.DbConnection;

/**
 * Servlet implementation class AddBlackSpot
 */
public class AddBlackSpot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBlackSpot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String location,address,reason,latitude,longitude,city,added_by;
		int level;
		
		location = request.getParameter("location");
		address = request.getParameter("address");
		reason = request.getParameter("reason");
		level = Integer.parseInt(request.getParameter("level"));
		latitude = request.getParameter("latitude");
		longitude = request.getParameter("longitude");
		city = request.getParameter("city");
		int pid = Credentials.getPolice_id();
		
		added_by = Credentials.getPolice_name();
		
		
		
		try {
			
			Connection con = DbConnection.connect();
					
					String insertQuery = "insert into blackspot_details (pid,location,address,reason,level,latitude,longitude,city,added_by) values(?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement ps = con.prepareStatement(insertQuery);
					ps.setInt(1, pid);
					ps.setString(2, location);
					ps.setString(3, address);
					ps.setString(4, reason);
					ps.setInt(5, level);
					ps.setString(6, latitude);
					ps.setString(7, longitude);
					ps.setString(8, city);
					ps.setString(9, added_by);
					
					int i = ps.executeUpdate();
					
					if(i>0){
						Thread.sleep(1000);
						response.sendRedirect("viewPBlackSpots.jsp");
						
					}else{
						response.sendRedirect("addBlackSpot.jsp");
						
						System.out.println("Ops! User is not registered.");
					}
			
			
			
					} catch (Exception e) {
						e.printStackTrace();
					}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
