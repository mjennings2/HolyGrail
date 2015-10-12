package com.bayviewglen.something;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeftOrRight {

	public JFrame frame;
	public boolean direction, wait;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeftOrRight window = new LeftOrRight();
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
	public LeftOrRight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 261, 84);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				direction = false;
				wait = true;
				
			}
		});
		btnLeft.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnLeft);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setBounds(119, 15, 17, 14);
		frame.getContentPane().add(lblOr);
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				direction = true;
				wait = true;
				
			}
		});
		btnRight.setBounds(146, 11, 89, 23);
		frame.getContentPane().add(btnRight);
	}
	
	public boolean getDir(){
		
		while(!wait){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		wait = false;	
		frame.setVisible(false);
		return direction;
	
	}
	
	
	
}
