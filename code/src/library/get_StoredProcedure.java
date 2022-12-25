package library;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class get_StoredProcedure {
	public static void InsertBook() {
		
        String query = "{ call InsertBook(?,?,?,?) }";
        ResultSet rs_insert;
        ResultSet rs2_insert;
 
        try ( 
        	Connection conn = library.ConnectDB();
            CallableStatement cstmt = conn.prepareCall(query)) {
 
            cstmt.setInt(1, 7);
            cstmt.setString(2, "Rừng Nauy");
            cstmt.setString(3, "Nhã Nam");
            cstmt.setString(4, "Haruki");
            
            rs_insert = cstmt.executeQuery();
            System.out.println("Querry success!");
            // get data from table 'book'
            Statement stmt = conn.createStatement();
            System.out.println("\nTable book after insert: \n");
            rs2_insert = stmt.executeQuery("SELECT * FROM book");
            // show data
            while (rs2_insert.next()) {
                System.out.println(rs2_insert.getInt(1) + "  " + rs2_insert.getString(2) 
                        + "  " + rs2_insert.getString(3));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
		
	}

	public static void DeleteBook() {
		// TODO Auto-generated method stub
		String query = "{ call DeleteBook(?) }";
        ResultSet rs_delete;
        ResultSet rs2_delete;
 
        try ( 
        	Connection conn = library.ConnectDB();
            CallableStatement cstmt = conn.prepareCall(query)) {
 
            cstmt.setInt(1, 7);
            
 
            rs_delete = cstmt.executeQuery();
            System.out.println("Querry success!");
            
            // get data from table 'book'
            Statement stmt = conn.createStatement();
            System.out.println("\nTable book after delete: \n");
            rs2_delete = stmt.executeQuery("SELECT * FROM book");
            // show data
            while (rs2_delete.next()) {
                System.out.println(rs2_delete.getInt(1) + "  " + rs2_delete.getString(2) 
                        + "  " + rs2_delete.getString(3));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
	}
}
