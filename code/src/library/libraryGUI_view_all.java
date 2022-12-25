package library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class libraryGUI_view_all {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					libraryGUI_view_all window = new libraryGUI_view_all();
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
	public libraryGUI_view_all() {
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
		
		JLabel lblView = new JLabel("View");
		lblView.setForeground(new Color(128, 128, 128));
		lblView.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblView.setHorizontalAlignment(SwingConstants.CENTER);
		lblView.setBounds(129, 28, 171, 37);
		frame.getContentPane().add(lblView);
		
		JButton btnViewBook = new JButton("View Books");
		btnViewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libraryGUI_book_view.main(new String[]{});
			}
		});
		btnViewBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnViewBook.setBounds(108, 85, 209, 37);
		frame.getContentPane().add(btnViewBook);
		
		JButton btnViewBorrower = new JButton("View Borrowers");
		btnViewBorrower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libraryGUI_borrower_view.main(new String[]{});
			}
		});
		btnViewBorrower.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnViewBorrower.setBounds(108, 143, 209, 37);
		frame.getContentPane().add(btnViewBorrower);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libraryGUI.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(149, 212, 125, 27);
		frame.getContentPane().add(btnBack);
		
	}
}
