package com.bayviewglen.something;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CurrentPlayers {

	public JFrame frame;
	private JButton btns[] = new JButton[8];
	private int playerChose;
	private boolean wait;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrentPlayers window = new CurrentPlayers(null);
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
	public CurrentPlayers(Player[] p){
		initialize(p);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Player[] p) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1044, 234);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		for(int i = 0; i < p.length; i++){
			btns[i] = new JButton("");
			btns[i].setBounds(15 + (i * 126), 52, 111, 111);
			//btns[i].setIcon(new ImageIcon(p[i].getColour()));
			frame.getContentPane().add(btns[i]);
			
		}
		if(p.length >= 1){
			btns[0].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						playerChose = 0;
						wait = true;
				
				}
			});
		}
		if(p.length >= 2){
			btns[1].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						playerChose = 1;
						wait = true;
				
				}
			});
		}
		if(p.length >= 3){
			btns[2].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						playerChose = 2;
						wait = true;
				
				}
			});
		}
		if(p.length >= 4){
			btns[3].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						playerChose = 3;
						wait = true;
				
				}
			});
		}
		if(p.length >= 5){
			btns[4].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						playerChose = 4;
						wait = true;
				
				}
			});
		}
		if(p.length >= 6){
			btns[5].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						playerChose = 5;
						wait = true;
				
				}
			});
		}
		if(p.length >= 7){
			btns[6].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						playerChose = 6;
						wait = true;
				
				}
			});
		}
		if(p.length >= 8){
			btns[7].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						playerChose = 7;
						wait = true;
				
				}
			});
		}
		
		
		
		
		JLabel lblNewLabel = new JLabel("Select Player:");
		lblNewLabel.setBounds(15, 16, 132, 20);
		frame.getContentPane().add(lblNewLabel);
	
	}
	
	public int getPlayer(Player[] p){
		
		while(!wait){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		wait = false;	
		frame.setVisible(false);
		return playerChose;
		
	}
}
