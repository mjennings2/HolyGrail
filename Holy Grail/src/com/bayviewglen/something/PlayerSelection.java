package com.bayviewglen.something;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class PlayerSelection extends JFrame {

	public JFrame frame;
	private boolean wait;
	private int number;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerSelection window = new PlayerSelection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlayerSelection() {
		frame = new JFrame();
		frame.setBounds(100, 100, 568, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 1;
				wait = true;
			}
		});
		button.setBounds(15, 62, 118, 75);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 2;
				wait = true;
			}
		});
		button_1.setBounds(148, 62, 118, 75);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 3;
				wait = true;
			}
		});
		button_2.setBounds(281, 62, 118, 75);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 4;
				wait = true;
			}
		});
		button_3.setBounds(414, 62, 118, 75);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 5;
				wait = true;
			}
		});
		button_4.setBounds(15, 153, 118, 75);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 6;
				wait = true;
			}
		});
		button_5.setBounds(146, 153, 118, 75);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 7;
				wait = true;
			}
		});
		button_6.setBounds(279, 153, 118, 75);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 8;
				wait = true;
			}
		});
		button_7.setBounds(412, 153, 118, 75);
		frame.getContentPane().add(button_7);
		
		JLabel lblSelectNumberOf = new JLabel("Select Number of Players:");
		lblSelectNumberOf.setBounds(179, 16, 186, 20);
		frame.getContentPane().add(lblSelectNumberOf);
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
