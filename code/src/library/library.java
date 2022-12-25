package library;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class library {


    public static void main(String args[]) {
        try {
            // connnect to database 'librabry_management'
            Connection conn = ConnectDB();
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'book'
            ResultSet rs = stmt.executeQuery("SELECT * FROM book");
            // show data
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) 
                        + "  " + rs.getString(3));
            }
            // close connection
            
            get_StoredProcedure.InsertBook();
            get_StoredProcedure.DeleteBook();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
 

    public static Connection ConnectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			 
			Connection conn = DriverManager.getConnection(  
					 "jdbc:mysql://localhost:3306/library_management","root","123456");  
			System.out.println("\nConnection Succeed!");
			return conn;
			
		} catch (Exception ex) { 
			System.out.println("\nConnection Error!" + ex.getMessage());

		}
		return null; 
	}

}
