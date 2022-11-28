package com.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbconnection.DbConnection;

/**
 * Servlet implementation class userRegister
 */
public class userRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name,email,password,city;
		long mobile;
		
		name = request.getParameter("name");
		email = request.getParameter("email");
		password = request.getParameter("password");
		city = request.getParameter("city");
		mobile = Long.parseLong(request.getParameter("mobile"));
		
		
		
		
		
		
		try {
			
			Connection con = DbConnection.connect();
					
					String insertQuery = "insert into user (name,email,mobile,pass,city) values(?,?,?,?,?)";
					
					PreparedStatement ps = con.prepareStatement(insertQuery);
					
					ps.setString(1, name);
					ps.setString(2, email);
					ps.setLong(3, mobile);
					ps.setString(4, password);
					ps.setString(5, city);
					
					int i = ps.executeUpdate();
					
					if(i>0){
						Thread.sleep(1000);
						response.sendRedirect("userLogin.html");
						
					}else{
						response.sendRedirect("userRegister.html");
						
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
