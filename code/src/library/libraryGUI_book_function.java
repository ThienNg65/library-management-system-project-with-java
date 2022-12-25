package library;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class libraryGUI_book_function {
	
	private JFrame frame;
	private JTextField textField_BookID;
	private JTextField textField_Title;
	private JTextField textField_Publisher;
	private JTextField textField_AuthorName;
	private JTextField textField_CopiesID;
	private JTextField textField_BranchID;
	private JTextField textField_NoCopies;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					libraryGUI_book_function window = new libraryGUI_book_function();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static int save(int book_BookID, String book_Title, String book_PublisherName, 
			String book_AuthorName, int book_copies_CopiesID, 
			int book_copies_BranchID, int book_copies_No_Of_Copies){
		int status=0;
		try {
			Connection con = library.ConnectDB();
			PreparedStatement ps=con.prepareStatement("call insert_full_Book(?, ?, ?, ?, ?, ?, ?)");
			// CallableStatement ps=con.prepareCall("{ call librabry_management.insert_full_Book(); }")) {
			ps.setInt(1, book_BookID);
			ps.setString(2, book_Title);
			ps.setString(3, book_PublisherName);
			ps.setString(4, book_AuthorName);
			ps.setInt(5, book_copies_CopiesID);
			ps.setInt(6, book_copies_BranchID);
			ps.setInt(7, book_copies_CopiesID);
			status=ps.executeUpdate();
			con.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	/**
	 * Create the application.
	 */
	public libraryGUI_book_function() {
		AddBook();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void AddBook() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddBook = new JLabel("Add Book");
		lblAddBook.setForeground(new Color(128, 128, 128));
		lblAddBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddBook.setBounds(211, 24, 123, 29);
		frame.getContentPane().add(lblAddBook);
		
		JLabel lblBookID = new JLabel("Book ID");
		lblBookID.setBounds(35, 86, 82, 29);
		frame.getContentPane().add(lblBookID);
		
		textField_BookID = new JTextField();
		textField_BookID.setBounds(127, 86, 123, 29);
		frame.getContentPane().add(textField_BookID);
		textField_BookID.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(35, 125, 82, 29);
		frame.getContentPane().add(lblTitle);
		
		textField_Title = new JTextField();
		textField_Title.setColumns(10);
		textField_Title.setBounds(127, 125, 123, 29);
		frame.getContentPane().add(textField_Title);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(35, 164, 82, 29);
		frame.getContentPane().add(lblPublisher);
		
		textField_Publisher = new JTextField();
		textField_Publisher.setColumns(10);
		textField_Publisher.setBounds(127, 164, 123, 29);
		frame.getContentPane().add(textField_Publisher);
		
		JLabel lblAuthorName = new JLabel("Author Name");
		lblAuthorName.setBounds(35, 203, 82, 29);
		frame.getContentPane().add(lblAuthorName);
		
		textField_AuthorName = new JTextField();
		textField_AuthorName.setColumns(10);
		textField_AuthorName.setBounds(127, 203, 123, 29);
		frame.getContentPane().add(textField_AuthorName);
		
		JLabel lblCopiesId = new JLabel("Copies ID");
		lblCopiesId.setBounds(283, 86, 82, 29);
		frame.getContentPane().add(lblCopiesId);
		
		textField_CopiesID = new JTextField();
		textField_CopiesID.setColumns(10);
		textField_CopiesID.setBounds(375, 86, 123, 29);
		frame.getContentPane().add(textField_CopiesID);
		
		JLabel lblBranchId = new JLabel("Branch ID");
		lblBranchId.setBounds(283, 125, 82, 29);
		frame.getContentPane().add(lblBranchId);
		
		textField_BranchID = new JTextField();
		textField_BranchID.setColumns(10);
		textField_BranchID.setBounds(375, 125, 123, 29);
		frame.getContentPane().add(textField_BranchID);
		
		JLabel lblNoCopies = new JLabel("No Copies");
		lblNoCopies.setBounds(283, 164, 82, 29);
		frame.getContentPane().add(lblNoCopies);
		
		textField_NoCopies = new JTextField();
		textField_NoCopies.setColumns(10);
		textField_NoCopies.setBounds(375, 164, 123, 29);
		frame.getContentPane().add(textField_NoCopies);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s_book_BookID = textField_BookID.getText();
				int book_BookID=Integer.parseInt(s_book_BookID);
				
				String book_Title = textField_Title.getText();
				String book_PublisherName = textField_Publisher.getText();
				String book_AuthorName = textField_AuthorName.getText();
				
				String s_book_copies_CopiesID = textField_CopiesID.getText();
				int book_copies_CopiesID = Integer.parseInt(s_book_copies_CopiesID);
				
				String s_book_copies_BranchID = textField_BranchID.getText();
				int book_copies_BranchID = Integer.parseInt(s_book_copies_BranchID);
				
				String s_book_copies_No_Of_Copies = textField_NoCopies.getText();
				int book_copies_No_Of_Copies = Integer.parseInt(s_book_copies_No_Of_Copies);
				
				int i = save( book_BookID, book_Title, book_PublisherName, 
						book_AuthorName,  book_copies_CopiesID, 
						book_copies_BranchID, book_copies_No_Of_Copies);
	
				if(i>0){
					JOptionPane.showMessageDialog(btnAddBook, "Books added successfully!");
					//LibrarianSuccess.main(new String[]{});
					
				}else{
					JOptionPane.showMessageDialog(btnAddBook, "Sorry, unable to save!");
					
				}
			}
		});
		btnAddBook.setBounds(157, 271, 111, 35);
		frame.getContentPane().add(btnAddBook);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libraryGUI.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setForeground(new Color(34, 34, 34));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBounds(291, 271, 111, 35);
		frame.getContentPane().add(btnBack);
		
		
		
	}
}
