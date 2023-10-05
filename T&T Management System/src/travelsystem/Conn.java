package travelsystem;

import java.sql.*;

public class Conn {
	
	Statement s;
	Conn(){
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem","root","cherry27");
		s = c.createStatement();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
