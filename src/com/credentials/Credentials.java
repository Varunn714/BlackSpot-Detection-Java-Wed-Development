package com.credentials;

public class Credentials {
	
	static boolean loggedIn = false;
	static int admin_id,police_id,user_id;
	static String admin_name,police_name,user_name,user_city,role;
	
	static double latitude,longitude;
	
	
	
	
	public static double getLatitude() {
		return latitude;
	}
	public static void setLatitude(double latitude) {
		Credentials.latitude = latitude;
	}
	public static double getLongitude() {
		return longitude;
	}
	public static void setLongitude(double longitude) {
		Credentials.longitude = longitude;
	}
	public static String getRole() {
		return role;
	}
	public static void setRole(String role) {
		Credentials.role = role;
	}
	public static String getUser_city() {
		return user_city;
	}
	public static void setUser_city(String user_city) {
		Credentials.user_city = user_city;
	}
	public static int getUser_id() {
		return user_id;
	}
	public static void setUser_id(int user_id) {
		Credentials.user_id = user_id;
	}
	public static String getUser_name() {
		return user_name;
	}
	public static void setUser_name(String user_name) {
		Credentials.user_name = user_name;
	}
	
	
	public static boolean isLoggedIn() {
		return loggedIn;
	}
	public static void setLoggedIn(boolean loggedIn) {
		Credentials.loggedIn = loggedIn;
	}
	
	public static int getAdmin_id() {
		return admin_id;
	}
	public static int getPolice_id() {
		return police_id;
	}
	public static void setPolice_id(int police_id) {
		Credentials.police_id = police_id;
	}
	public static String getPolice_name() {
		return police_name;
	}
	public static void setPolice_name(String police_name) {
		Credentials.police_name = police_name;
	}
	public static void setAdmin_id(int admin_id) {
		Credentials.admin_id = admin_id;
	}
	
	
	public static String getAdmin_name() {
		return admin_name;
	}
	public static void setAdmin_name(String admin_name) {
		Credentials.admin_name = admin_name;
	}
	
	

}

