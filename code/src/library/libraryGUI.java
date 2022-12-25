package library;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;
import java.awt.Color;

public class libraryGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					libraryGUI window = new libraryGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public libraryGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libraryGUI_book_function.main(new String[]{});
				frame.dispose();
			}
		});
		btnAddBook.setBounds(121, 66, 210, 42);
		frame.getContentPane().add(btnAddBook);
		
		JButton btnViewBook = new JButton("View Book");
		btnViewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libraryGUI_view_all.main(new String[]{});
			}
		});
		btnViewBook.setBounds(121, 128, 205, 42);
		frame.getContentPane().add(btnViewBook);
		
		JButton btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libraryGUI_book_delete.main(new String[]{});
				frame.dispose();
			}
		});
		btnDeleteBook.setBounds(121, 188, 205, 42);
		frame.getContentPane().add(btnDeleteBook);
		

		
		JLabel lblLibrarySystem = new JLabel("LIBRARY SYSTEM");
		lblLibrarySystem.setForeground(new Color(128, 128, 128));
		lblLibrarySystem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLibrarySystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrarySystem.setBounds(121, 23, 205, 26);
		frame.getContentPane().add(lblLibrarySystem);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Library Database System",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(121, 250, 205, 42);
		frame.getContentPane().add(btnExit);
	}
	
	
}
