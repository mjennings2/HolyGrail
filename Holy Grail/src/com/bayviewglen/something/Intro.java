package com.bayviewglen.something;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class Intro extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private boolean wait;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intro frame = new Intro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Intro() {
		initialize();
	}
	
	private void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1244, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStart.setAction(action);
		btnStart.setBounds(526, 266, 185, 88);
		contentPane.add(btnStart);
		
		JButton btnHowToPlay = new JButton("How To Play");
		btnHowToPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Instructions instructions = new Instructions();
				instructions.frame.setVisible(true);
				
			}
		});
		btnHowToPlay.setBounds(1084, 485, 123, 29);
		contentPane.add(btnHowToPlay);
		
		JLabel lblD = new JLabel("d");
		lblD.setIcon(new ImageIcon("input/pictures/intro.png"));
		lblD.setBounds(0, 0, 1222, 530);
		contentPane.add(lblD);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Start");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			setVisible(false);
			wait = true;
			
		}
	}
	
public int loop(){
		
		while(!wait){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		wait = false;
		return 0;
	
	}
}
