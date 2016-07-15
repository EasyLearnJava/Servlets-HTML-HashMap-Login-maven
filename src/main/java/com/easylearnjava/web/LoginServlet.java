package com.easylearnjava.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easylearnjava.util.Constants;

/**
 * 
 * @author rnr
 *
 *         LoginServlet inherits all the features of a servlet by extending
 *         HttpServlet. By default the doPost method will be called by the
 *         webContainer. If valid credentials are given the user is redirected
 *         to success page. If invalid credentials are entered then the login
 *         page is displayed back to the user. 
 */
public class LoginServlet extends HttpServlet {

	/**
	 * This is auto generated
	 */
	private static final long serialVersionUID = -8145663309844069243L;

	static Map<String, String> hashMapDB = new HashMap<String, String>();

	static {
		hashMapDB.put("raghu", "secret");
		hashMapDB.put("naveen", "topsecret");
	}
	

	/**
	 * User will be redirected to login page if the success link is accessed directly
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter(  ); 
	    response.setContentType("text/html");   
		out.println("<html>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
		out.println("<title>Servlet HTML HashMap Login Example</title>");
		out.println("<script type=\"text/javascript\" src=\"js/appJS.js\"></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 align=\"center\">Login functionality implemented using Servlet, HTML and HashMap</h2>");
		out.println("<form action=\"login\" method=\"post\">");
		out.println("<table align=\"center\" border=\"0\">");
		out.println("<tr> <td >username :</td>");
		out.println("<td ><input type=\"text\" name=\"usernameTB\" id=\"userid\"></td>");
		out.println("</tr> <tr> <td>password :</td>");
		out.println("<td ><input type=\"password\" name=\"passwordTB\" id=\"password\"><br></td>");
		out.println("</tr> <tr>");
		out.println("<td ><input type=\"submit\" value=\"login\" onclick=\"return validateData();\"></td>");
		out.println("<td> </td> </tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	

	/**
	 * The request comes to this method when the login button is clicked
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try {
			// get the user entered input values from the "HttpServletRequest" object, i.e request
			String userNameStr = request.getParameter("usernameTB");
			String passwordStr = request.getParameter("passwordTB");

			// inputdata validation
			boolean isDataValid = isValidData(userNameStr, passwordStr);
			if (!isDataValid) {
				PrintWriter out = response.getWriter(  ); 
			    response.setContentType("text/html");   
				out.println("<html>");
				out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
				out.println("<title>Servlet HTML HashMap Login Example</title>");
				out.println("<script type=\"text/javascript\" src=\"js/appJS.js\"></script>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2 align=\"center\">Login functionality implemented using Servlet, HTML and HashMap</h2>");
				out.println("<form action=\"login\" method=\"post\">");
				out.println("<table align=\"center\" border=\"0\">");
				out.println("<tr> <td >username :</td>");
				out.println("<td ><input type=\"text\" name=\"usernameTB\" id=\"userid\"></td>");
				out.println("</tr> <tr> <td>password :</td>");
				out.println("<td ><input type=\"password\" name=\"passwordTB\" id=\"password\"><br></td>");
				out.println("</tr> <tr>");
				out.println("<td ><input type=\"submit\" value=\"login\" onclick=\"return validateData();\"></td>");
				out.println("<td style=\"color: red;\">username/password cannot be empty, <br> must contain atleast 5 characters each</td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
				return;
			}

			boolean isValid = isValidPassword(userNameStr, passwordStr);

			if (isValid) {
				PrintWriter out = response.getWriter(  ); 
			    response.setContentType("text/html");   
			    //out.println("<a href=\"login.html\"> LogOut ...</a>"); 
			    out.println("<h2>Successfully logged in to the application ... :)</h2>");
			} else {
				System.out.println("Invalid login credentials");
				PrintWriter out = response.getWriter(  ); 
			    response.setContentType("text/html");   
				out.println("<html>");
				out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
				out.println("<title>Servlet HTML HashMap Login Example</title>");
				out.println("<script type=\"text/javascript\" src=\"js/appJS.js\"></script>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2 align=\"center\">Login functionality implemented using Servlet, HTML and HashMap</h2>");
				out.println("<form action=\"login\" method=\"post\">");
				out.println("<table align=\"center\" border=\"0\">");
				out.println("<tr> <td >username :</td>");
				out.println("<td ><input type=\"text\" name=\"usernameTB\" id=\"userid\"></td>");
				out.println("</tr> <tr> <td>password :</td>");
				out.println("<td ><input type=\"password\" name=\"passwordTB\" id=\"password\"><br></td>");
				out.println("</tr> <tr>");
				out.println("<td ><input type=\"submit\" value=\"login\" onclick=\"return validateData();\"></td>");
				out.println("<td style=\"color: red;\">Invalid login credentials</td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(Constants.GLOBAL_EXCEPTION_MESSAGE);
			PrintWriter out = response.getWriter(  ); 
		    response.setContentType("text/html");   
			out.println("<html>");
			out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
			out.println("<title>Servlet HTML HashMap Login Example</title>");
			out.println("<script type=\"text/javascript\" src=\"js/appJS.js\"></script>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2 align=\"center\">Login functionality implemented using Servlet, HTML and HashMap</h2>");
			out.println("<form action=\"login\" method=\"post\">");
			out.println("<table align=\"center\" border=\"0\">");
			out.println("<tr> <td >username :</td>");
			out.println("<td ><input type=\"text\" name=\"usernameTB\" id=\"userid\"></td>");
			out.println("</tr> <tr> <td>password :</td>");
			out.println("<td ><input type=\"password\" name=\"passwordTB\" id=\"password\"><br></td>");
			out.println("</tr> <tr>");
			out.println("<td ><input type=\"submit\" value=\"login\" onclick=\"return validateData();\"></td>");
			out.println("<td style=\"color: red;\">Please try again after some time</td></tr>");
			out.println("</table>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");			
		}
	}
	

	/**
	 * Method for validating the input values
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean isValidData(String userName, String password) {

		if ((null != userName) && (userName != "") && (userName.length() >= 5)) {
			if ((null != password) && (password != "") && (password.length() >= 5)) {
				return true;
			}
		}
		return false;
	}
	

	/**
	 * Method for implementing the business logic, like comparing the passwords
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean isValidPassword(String userName, String password) {

		String pwdFromDB = getUserPassword(userName);
		if (null != pwdFromDB) {
			if (pwdFromDB.equals(password)) {
				return true;
			}
		}
		return false;
	}
	

	/**
	 * Method which fetches password for the user name from the hashmap
	 * 
	 * @param userName
	 * @return
	 */
	public String getUserPassword(String userName) {
		// "null" will be returned if the userName match is not found in the hashMap
		String storedPassword = hashMapDB.get(userName);
		return storedPassword;
	}

}
