package page;

import java.sql.*;

public class DatabasePage {

	public String getData(String columnName) throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/orange","root", "root");
	Statement smt = con.createStatement();
	ResultSet rs = smt.executeQuery("select * from login");
	while(rs.next()) {
		return rs.getString(columnName);
	}
	
	return columnName;
	
}

}
