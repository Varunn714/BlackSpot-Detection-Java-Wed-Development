package com.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbconnection.DbConnection;


/**
 * Servlet implementation class AddPoliceStation
 */
public class AddPoliceStation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPoliceStation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name,address,email,password;
		long contact;
		
		name = request.getParameter("name");
		address = request.getParameter("address");
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		contact = Long.parseLong(request.getParameter("contact"));
		
		
		
		
		
		try {
			
			Connection con = DbConnection.connect();
			
			PreparedStatement ps1 = con.prepareStatement("select * from police_station where email = ?");
			
			ps1.setString(1, email);
			
			
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs1.next()){
				response.sendRedirect("addPoliceStation.html");
				System.out.println("Email is already Exist. Please Login or change the Email.");
				return;
			}else{
					
					String insertQuery = "insert into police_station (name,email,pass,address,contact) values(?,?,?,?,?)";
					
					PreparedStatement ps = con.prepareStatement(insertQuery);
					
					ps.setString(1, name);
					ps.setString(2, email);
					ps.setString(3, password);
					ps.setString(4, address);
					ps.setLong(5, contact);
					
					int i = ps.executeUpdate();
					
					if(i>0){
						Thread.sleep(2000);
						response.sendRedirect("viewPoliceStation.jsp");
						
					}else{
						response.sendRedirect("addPoliceStation.jsp");
						System.out.println("Ops! User is not registered.");
					}

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
