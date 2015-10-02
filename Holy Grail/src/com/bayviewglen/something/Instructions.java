package com.bayviewglen.something;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Instructions {

	public JFrame frame;
	public boolean wait;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instructions window = new Instructions();
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
	public Instructions() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1017, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				
			}
		});
		btnClose.setBounds(815, 432, 115, 29);
		frame.getContentPane().add(btnClose);
		
		JLabel lblPic = new JLabel("pic");
		lblPic.setIcon(new ImageIcon("input/pictures/rules.png"));
		lblPic.setBounds(0, 0, 1001, 476);
		frame.getContentPane().add(lblPic);
	}
	
	
	
}
