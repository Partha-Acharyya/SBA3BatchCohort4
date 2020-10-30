package com.wf.sba3.ibs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.sba3.ibs.Entity.CreditCardEligibility;
import com.wf.sba3.ibs.doa.CreditcardEligibilityDao;


/**
 * Servlet implementation class CardManagement
 */
@WebServlet("/CardManagement")
public class CardManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardManagement() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	String driver = config.getServletContext().getInitParameter("jdbcDriver");
    	String url = config.getServletContext().getInitParameter("jdbcUrl");
    	String username = config.getServletContext().getInitParameter("jdbcUsername");
    	String password = config.getServletContext().getInitParameter("jdbcPassword");
    	
    	CreditcardEligibilityDao ccd = new CreditcardEligibilityDao(driver, url, username, password);
    	try {
			ccd.connect();
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
		// TODO Auto-generated method stub
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		Long MobileNumber = Long.parseLong(request.getParameter("MobileNumber"));
		String TypeOfEmployment = request.getParameter("TypeOfEmployment");
		String TotalIncome = request.getParameter("TotalIncome");
		String Email = request.getParameter("Email");
		Date birthday = null;
		try {
			birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		CreditCardEligibility C = new CreditCardEligibility(FirstName, LastName, MobileNumber, TypeOfEmployment, TotalIncome, Email, birthday);
		request.setAttribute("CreditCardEligibility", C);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CCEligibility_Success.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				doGet(request, response);
	}
	

}
