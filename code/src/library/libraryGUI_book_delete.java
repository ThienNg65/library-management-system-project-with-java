package library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class libraryGUI_book_delete {

	private JFrame frame;
	private JTextField EnterID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					libraryGUI_book_delete window = new libraryGUI_book_delete();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static int delete_book(int book_BookID){
		int status=0;
		try ( 
			Connection con = library.ConnectDB();
			CallableStatement ps=con.prepareCall("{ call DeleteBook(?) }")) {
			ps.setInt(1,book_BookID);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	/**
	 * Create the application.
	 */
	public libraryGUI_book_delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterID = new JLabel("Enter ID: ");
		lblEnterID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterID.setBounds(36, 88, 95, 26);
		frame.getContentPane().add(lblEnterID);
		
		JLabel lblDeleteBook = new JLabel("Delete Book");
		lblDeleteBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteBook.setForeground(new Color(52, 52, 52));
		lblDeleteBook.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDeleteBook.setBounds(147, 25, 148, 42);
		frame.getContentPane().add(lblDeleteBook);
		
		EnterID = new JTextField();
		EnterID.setBounds(147, 88, 251, 26);
		frame.getContentPane().add(EnterID);
		EnterID.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid = EnterID.getText();
				if(sid == null || sid.trim().equals("")){
					JOptionPane.showMessageDialog(btnDelete, "Id can't be blank");
				} else {
					int id=Integer.parseInt(sid);
					int i= delete_book(id);
					if(i>0) {
						JOptionPane.showMessageDialog(btnDelete,"Record deleted successfully!");
					} else {
						JOptionPane.showMessageDialog(btnDelete,"Unable to delete given id!");
					}
				}
			}
		});
		btnDelete.setBounds(147, 145, 148, 42);
		frame.getContentPane().add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libraryGUI.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBack.setBounds(303, 200, 95, 33);
		frame.getContentPane().add(btnBack);
	}

}
