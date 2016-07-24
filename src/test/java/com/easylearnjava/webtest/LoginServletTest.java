package com.easylearnjava.webtest;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.AtLeast;

import com.easylearnjava.util.Constants;
import com.easylearnjava.web.LoginServlet;

import junit.framework.TestCase;

public class LoginServletTest extends TestCase {

	@Mock
	private LoginServlet loginServlet;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@Mock
	private RequestDispatcher rd;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		//loginServlet = new LoginServlet();
		// request = mock(HttpServletRequest.class);
		// response = mock(HttpServletResponse.class);
	}
	

	@Test
	public void testSuccessFullLogin() throws ServletException, IOException {

		//LoginServlet lServlet = new LoginServlet();
		
		when(request.getParameter("usernameTB")).thenReturn("raghu");
		when(request.getParameter("passwordTB")).thenReturn("secret");
		when(request.getRequestDispatcher("loginSuccess.html")).thenReturn(rd);
		
		loginServlet.doPost(request, response);
		verify(loginServlet, times(1)).doPost(request, response);
	}	
	
	@Test
	public void testInvalidData() throws ServletException, IOException {

		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);

		when(request.getParameter("usernameTB")).thenReturn("abc");
		when(request.getParameter("passwordTB")).thenReturn("secret");
		when(response.getWriter()).thenReturn(printWriter);

		loginServlet.doPost(request, response);
		verify(loginServlet, times(1)).doPost(request, response);
	}
	
	@Test
	public void testUnSuccessfullLogin() throws ServletException, IOException {

		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);

		when(request.getParameter("usernameTB")).thenReturn("abc");
		when(request.getParameter("passwordTB")).thenReturn("secret");
		when(response.getWriter()).thenReturn(printWriter);

		loginServlet.doPost(request, response);
		verify(loginServlet, times(1)).doPost(request, response);
	}

}
