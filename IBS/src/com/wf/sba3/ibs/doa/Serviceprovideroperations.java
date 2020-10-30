package com.wf.sba3.ibs.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import  com.wf.sba3.ibs.Entity.serviceproviderdetails;

//import com.wf.sba3.ibs.Entity.CreditCardEligibility;

public class Serviceprovideroperations {
			
		private String driverName;
		private String url;
		private String username;
		private String password;
		private Connection connection;
		
		public Serviceprovideroperations(String driverName, String url, String username, String password,
				Connection connection) {
			super();
			this.driverName = driverName;
			this.url = url;
			this.username = username;
			this.password = password;
			this.connection = connection;
		}

		public void connect() throws ClassNotFoundException, SQLException {
			if(this.connection == null || this.connection.isClosed()) {
				Class.forName(this.driverName);
				this.connection = DriverManager.getConnection(this.url,this.username,this.password);
			}
		}
		
		public void disConnect() throws SQLException {
			if(this.connection!=null && !this.connection.isClosed())
			{
				this.connection.close();
				
		    }
	   }
		public void setServiceProvider(serviceproviderdetails serv) throws SQLException {
			String stmtstr = "INSERT INTO serviceprovider"+" (providername, member1,member2,networth, expectednetworth, pan, currentaccountnumber,currentacccountbranch,currentacccountifsccode,currentacccountname, phonenumber,SPI) VALUES" + " (?,?,?,?,?,?,?,?,?,?,?,?);";
			int result = 0;
			PreparedStatement stmt = connection.prepareStatement(stmtstr);
			stmt.setInt(1, serv.getSPI());
			stmt.setString(2, serv.getCurrentacccountbranch());
			stmt.setString(3, serv.getCurrentacccountifsccode());
			stmt.setString(4, serv.getCurrentacccountname());
			stmt.setString(5, serv.getCurrentaccountnumber());
			stmt.setDouble(6, serv.getExpectednetworth());
			stmt.setString(7, serv.getPhonenumber());
			stmt.setString(8, serv.getMember1());
			stmt.setString(9, serv.getMember2());
			stmt.setDouble(10, serv.getNetworth());
			stmt.setString(11, serv.getPhonenumber());
			stmt.setString(12, serv.getPan());
			
	   }
		
			
}
