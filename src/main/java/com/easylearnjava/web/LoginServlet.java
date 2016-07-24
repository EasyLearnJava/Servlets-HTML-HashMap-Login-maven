package com.easylearnjava.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easylearnjava.util.Constants;

/**
 * 
 * @author rnr
 *
 *         LoginServlet class inherits all the features of a servlet by extending
 *         HttpServlet. By default the doGet method will be called by the 
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
	 * The request comes to this method when the login button is clicked
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html"); 

		try {
			// get the user entered input values from the "HttpServletRequest" object, i.e request
			String userNameStr = request.getParameter("usernameTB");
			String passwordStr = request.getParameter("passwordTB");

			// inputdata validation
			boolean isDataValid = isValidData(userNameStr, passwordStr);
			if (!isDataValid) {
				RequestDispatcher rd = request.getRequestDispatcher("loginInvalidData.html");
				rd.forward(request, response);
				return;
			}

			boolean isValid = isValidPassword(userNameStr, passwordStr);

			if (isValid) {
				RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.html");
				rd.forward(request, response);
				return;
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("loginInvalid.html");
				rd.forward(request, response);
				return;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(Constants.GLOBAL_EXCEPTION_MESSAGE);
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			return;
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
