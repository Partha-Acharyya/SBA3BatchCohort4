package CustomerInitiation;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.NewCustomerCheck;

/**
 * Servlet implementation class registrationServ
 */
@WebServlet("/registrationServ")
public class registrationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String contact= request.getParameter("ContactNum");
		String Address= request.getParameter("Address");
		String DOB= request.getParameter("DOB");
		
		NewCustomerCheck cust1= new NewCustomerCheck(name, email, contact, Address, DOB);
		
		request.setAttribute("Customer", cust1);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("UnregisteredCust.jsp");
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
