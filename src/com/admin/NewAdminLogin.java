package com.admin;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.credentials.Credentials;
import com.dbconnection.DbConnection;

/**
 * Servlet implementation class NewAdminLogin
 */

/*@WebServlet("/NewAdminLogin")*/
public class NewAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAdminLogin() {
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
		
		
		try {
			Connection con = DbConnection.connect();
			
			response.setContentType("text/plain");

		    PrintWriter out = response.getWriter();
			
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
				
				
			      out.println("success");
				
//				response.sendRedirect("adminDashboard.jsp");				
				
				
			}else{
				out.println("error");
				
//				response.sendRedirect("adminLogin.html");	
//				System.out.println("Ops! Invalid Credentials Please try again.");
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
