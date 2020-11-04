package com.wf.sba3.ibs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.sba3.ibs.doa.CreditcardDao;

/**
 * Servlet implementation class CCCheckStatus
 */
@WebServlet("/CCCheckStatus")
public class CheckCCStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CreditcardDao CreditcardDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCCStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	String driver = config.getServletContext().getInitParameter("jdbcDriver");
    	String url = config.getServletContext().getInitParameter("jdbcUrl");
    	String username = config.getServletContext().getInitParameter("jdbcUsername");
    	String password = config.getServletContext().getInitParameter("jdbcPassword");
    	
    	this.CreditcardDao= new CreditcardDao(driver, url, username, password);
    	try {
    		CreditcardDao.connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		// TODO Auto-generated method stub
	String ReferenceId = request.getParameter("ReferenceId");
		String MobileNumber = request.getParameter("MobileNumber");
		String Email = request.getParameter("Email");
		try {
			
			ResultSet s=CreditcardDao.CheckCreditCardStatus("1b67d7fc-5ff5-4683-9694-2e7c05bd1862","9596963265","robins@gmail.com");
		
		out.print("<h1>Your credit card status is in </h1>");
		out.print(s);
		while(s.next())
		out.print(s.getString(1));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.print("Enter valid details to retrieve your credit card status");
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
