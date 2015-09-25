package com.bayviewglen.something;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Button;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Choice;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class Main extends JFrame {

	private JPanel contentPane;
	private JLabel lblP;
	private int lblPX = 814;
	private int lblPY = 321;
	private JTextArea textArea;
	private final Action action = new SwingAction();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public void movePlayer(JLabel player, int squares, int square, boolean forward, Square[] s){
		
		if(forward){
			player.setBounds(s[square+squares].getX(), s[square+squares].getY(), 22, 22);	
			revalidate();
		}else{
			player.setBounds(s[square-squares].getX(), s[square-squares].getY(), 22, 22);
			revalidate();
		}
		
		
		
	}
	
	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 760);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmRestart = new JMenuItem("Restart");
		mnFile.add(mntmRestart);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(15, 566, 1314, 122);
		contentPane.add(textArea);
		
		JLabel lblCurrentPlayer = new JLabel("Current Player");
		lblCurrentPlayer.setBounds(1031, 16, 113, 20);
		contentPane.add(lblCurrentPlayer);
		
		JLabel lblPic_1 = new JLabel("pic");
		lblPic_1.setIcon(new ImageIcon("input/pictures/Trump.png"));
		lblPic_1.setBounds(1031, 52, 113, 111);
		contentPane.add(lblPic_1);
		
		JLabel lblCard = new JLabel("Card");
		lblCard.setIcon(new ImageIcon("input/pictures/Ace.png"));
		lblCard.setBounds(1195, 16, 113, 160);
		contentPane.add(lblCard);
		
		lblP = new JLabel("p1");
		lblP.setIcon(new ImageIcon("input/pictures/Trump22.png"));
		lblP.setBounds(754, 321, 22, 22);
		contentPane.add(lblP);
		
		JLabel lblPic = new JLabel("Pic");
		lblPic.setIcon(new ImageIcon("input/pictures/Holy Grail Hunting or Somthing.png"));
		lblPic.setBounds(15, 16, 1001, 534);
		contentPane.add(lblPic);
		
		JButton btnMove = new JButton("Move");
		btnMove.setAction(action);
		btnMove.setBounds(1122, 318, 115, 29);
		contentPane.add(btnMove);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			textArea.append("HI");
			System.out.print("HI");
			movePlayer(lblP, 1, 1, true, null);
			
		}
	}
}
