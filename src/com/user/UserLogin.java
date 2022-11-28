package com.user;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.IOException;
import java.net.URL;
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
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		double latitude,longitude;
		
//		If latitude in not provided
		
		if(Double.parseDouble(request.getParameter("latitude")) == 0 ){
			latitude = 0;
		}else{
			latitude = Double.parseDouble(request.getParameter("latitude"));
		}
//		If longitude in not provided
		
		if(Double.parseDouble(request.getParameter("longitude")) == 0){
			
			longitude = 0;
			
		}else{
			
			longitude = Double.parseDouble(request.getParameter("longitude"));
			
		}
		
		
		try {
			Connection con = DbConnection.connect();
			
			PreparedStatement ps = con.prepareStatement("select * from user where email = ? and pass=?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				
				Credentials.setLoggedIn(true);
				Credentials.setUser_id(rs.getInt(1));
				Credentials.setUser_name(rs.getString(2));
				Credentials.setUser_city(rs.getString(6));
				Credentials.setRole("user");
				Credentials.setLatitude(latitude);
				Credentials.setLongitude(longitude);
				
				
				try {
					URL url = new URL("file:C:/temp/beep-04.wav");
					AudioClip clip = Applet.newAudioClip(url);
					clip.play();
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				response.sendRedirect("userDashboard.jsp");				
				
				
			}else{
				response.sendRedirect("userLogin.html");	
				System.out.println("Ops! Invalid Credentials Please try again.");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
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
