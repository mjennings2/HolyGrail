package com.bayviewglen.something;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NumberChooser {

	public JFrame frame;
	private int number;
	private boolean wait;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberChooser window = new NumberChooser();
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
	public NumberChooser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 210, 323);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 1;
				wait = true;
			}
		});
		button.setBounds(15, 42, 151, 29);
		frame.getContentPane().add(button);
		
		JLabel lblHowManySquares = new JLabel("How many squares?");
		lblHowManySquares.setBounds(15, 18, 197, 20);
		frame.getContentPane().add(lblHowManySquares);
		
		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 2;
				wait = true;
			}
		});
		button_1.setBounds(15, 87, 151, 29);
		frame.getContentPane().add(button_1);
		
		JButton btnNewButton = new JButton("3");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 3;
				wait = true;
			}
		});
		btnNewButton.setBounds(15, 132, 151, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton button_2 = new JButton("4");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 4;
				wait = true;
			}
		});
		button_2.setBounds(15, 177, 151, 29);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("5");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 5;
				wait = true;
			}
		});
		button_3.setBounds(15, 222, 151, 29);
		frame.getContentPane().add(button_3);
	}
	
	public int getNumber(){
		
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
		return number;
	
	}

}
