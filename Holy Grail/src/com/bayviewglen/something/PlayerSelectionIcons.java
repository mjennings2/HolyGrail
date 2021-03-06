package com.bayviewglen.something;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PlayerSelectionIcons {
	private JLabel lblPlayerPlease;
	public JFrame frame;
	private JLabel lblHi;
	boolean wait;
	int iconUsed;
	int playerChooseing;
	boolean used[] = new boolean[8];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerSelectionIcons window = new PlayerSelectionIcons(new Player[8]);
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
	public PlayerSelectionIcons(Player[] p) {
		initialize(p);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Player[] p) {
		frame = new JFrame();
		frame.setBounds(100, 100, 548, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnTrump = new JButton("");
		btnTrump.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(used[0]){
					lblHi.setText("Sorry but that icon is in use. Please choose a different icon.");
					frame.revalidate();
				}else{
					p[playerChooseing].setColour("input/pictures/Trump.png");
					p[playerChooseing].setColourSmall("input/pictures/Trump22.png");
					used[0] = true;
					wait = true;
					
				}
				
			}
		});
		btnTrump.setIcon(new ImageIcon("input/pictures/Trump.png"));
		btnTrump.setBounds(15, 78, 111, 111);
		frame.getContentPane().add(btnTrump);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(used[1]){
					lblHi.setText("Sorry but that icon is in use. Please choose a different icon.");
					frame.revalidate();
				}else{
					used[1] = true;
					p[playerChooseing].setColour("input/pictures/Queen.png");
					p[playerChooseing].setColourSmall("input/pictures/Queen22.png");
					wait = true;
				}
			}
		});
		button.setIcon(new ImageIcon("input/pictures/Queen.png"));
		button.setBounds(141, 78, 111, 111);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(used[2]){
					lblHi.setText("Sorry but that icon is in use. Please choose a different icon.");
					frame.revalidate();
				}else{
					used[2] = true;
					p[playerChooseing].setColour("input/pictures/Berlusconi.png");
					p[playerChooseing].setColourSmall("input/pictures/Berlusconi22.png");
					wait = true;
				}
			}
		});
		button_1.setIcon(new ImageIcon("input/pictures/Berlusconi.png"));
		button_1.setBounds(267, 78, 111, 111);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(used[3]){
					lblHi.setText("Sorry but that icon is in use. Please choose a different icon.");
					frame.revalidate();
				}else{
					used[3] = true;
					p[playerChooseing].setColour("input/pictures/Dilma.png");
					p[playerChooseing].setColourSmall("input/pictures/Dilma22.png");
					wait = true;
				}
			}
		});
		button_2.setIcon(new ImageIcon("input/pictures/Dilma.png"));
		button_2.setBounds(393, 78, 111, 111);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(used[4]){
					lblHi.setText("Sorry but that icon is in use. Please choose a different icon.");
					frame.revalidate();
				}else{
					used[4] = true;
					p[playerChooseing].setColour("input/pictures/Kim_jong-un.png");
					p[playerChooseing].setColourSmall("input/pictures/Kim_jong-un22.png");
					wait = true;
				}
			}
		});
		button_3.setIcon(new ImageIcon("input/pictures/Kim_jong-un.png"));
		button_3.setBounds(15, 205, 111, 111);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(used[5]){
					lblHi.setText("Sorry but that icon is in use. Please choose a different icon.");
					frame.revalidate();
				}else{
					used[5] = true;
					p[playerChooseing].setColour("input/pictures/Hollande.png");
					p[playerChooseing].setColourSmall("input/pictures/Hollande22.png");
					wait = true;
				}
			}
		});
		button_4.setIcon(new ImageIcon("input/pictures/Hollande.png"));
		button_4.setBounds(141, 205, 111, 111);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(used[6]){
					lblHi.setText("Sorry but that icon is in use. Please choose a different icon.");
					frame.revalidate();
				}else{
					used[6] = true;
					p[playerChooseing].setColour("input/pictures/Obama.png");
					p[playerChooseing].setColourSmall("input/pictures/Obama22.png");
					wait = true;
				}
			}
		});
		button_5.setIcon(new ImageIcon("input/pictures/Obama.png"));
		button_5.setBounds(267, 205, 111, 111);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(used[7]){
					lblHi.setText("Sorry but that icon is in use. Please choose a different icon.");
					frame.revalidate();
				}else{
					used[7] = true;
					p[playerChooseing].setColour("input/pictures/Putin.png");
					p[playerChooseing].setColourSmall("input/pictures/Putin22.png");
					wait = true;
				}
			}
		});
		button_6.setIcon(new ImageIcon("input/pictures/Putin.png"));
		button_6.setBounds(393, 205, 111, 111);
		frame.getContentPane().add(button_6);
		
		lblPlayerPlease = new JLabel("");
		lblPlayerPlease.setBounds(141, 16, 236, 20);
		frame.getContentPane().add(lblPlayerPlease);
		
		lblHi = new JLabel("");
		lblHi.setBounds(15, 328, 489, 20);
		frame.getContentPane().add(lblHi);
		
		
	}
	
	public void getPlayerIcons(Player[] p){
		
		for(int i = 0; i < p.length; i++){
			
			lblPlayerPlease.setText("Player " + (i+1) + ", Please select your Icon");
			frame.revalidate();
			playerChooseing = i;
			while(!wait){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			wait = false;	
			
		}
		frame.setVisible(false);
		
	}
}
