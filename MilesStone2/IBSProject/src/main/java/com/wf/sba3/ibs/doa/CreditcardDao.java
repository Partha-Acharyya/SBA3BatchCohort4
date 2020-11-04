package com.wf.sba3.ibs.doa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wf.sba3.ibs.Entity.CreditCardEligibility;

public class CreditcardDao 
{

	private String driverName;
	private String url;
	private String username;
	private String password;
	
	private Connection connection;
	
	public CreditcardDao(String driverName, String url, String username, String password) {
		super();
		this.driverName = driverName;
		this.url = url;
		this.username = username;
		this.password = password;
		
	}

	public void connect() throws ClassNotFoundException, SQLException {
		if(this.connection == null || this.connection.isClosed()) {
			Class.forName(this.driverName);
			this.connection = DriverManager.getConnection(this.url,this.username,this.password);
		}
	}
	
	private void disConnect() throws SQLException {
		if(this.connection!=null && !this.connection.isClosed())
		{
			this.connection.close();
	}
	}
	public int InsertCCEligibilityDetails(CreditCardEligibility c) throws SQLException{
		int result=0;
		try {
		String SQL="insert into cc_eligibility" 
				+"(ReferenceID,FirstName,LastName,"
				+	"birthday,MobileNumber,TypeOfEmployment, TotalIncome, Email) values"
				+ "(?,?,?,?,?,?,?,?);";
		PreparedStatement pstmt=connection.prepareStatement(SQL);
		pstmt.setString(1,CreditCardEligibility.getReferenceID());
		pstmt.setString(2,CreditCardEligibility.getFirstName());
		pstmt.setString(3,CreditCardEligibility.getLastName());
		pstmt.setString(4,CreditCardEligibility.getBirthday());
		pstmt.setLong(5,CreditCardEligibility.getMobileNumber());
		pstmt.setString(6,CreditCardEligibility.getTypeOfEmployment());
		pstmt.setString(7,CreditCardEligibility.getTotalIncome());
		pstmt.setString(8,CreditCardEligibility.getEmail());
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return result;	
	}
		public ResultSet CheckCreditCardStatus(String ReferenceID, String mobileNumber, String email) throws SQLException{
			
		
			String SQL="select status from ibs.cc_eligibility" 
					+"where ReferenceID = '"+ReferenceID+"'"+ "and mobileNumber = '"+mobileNumber+"'"
					+ "and email = '"+email+"'";
			Statement stmt = this.connection.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			return rs;
	
				
	}
	
}
