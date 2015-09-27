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
import java.util.ArrayList;

import javax.swing.Action;

public class Main extends JFrame {

	private JPanel contentPane;
	private JLabel lblP[] = new JLabel[8];
	private JLabel lblPic_1;
	private int lblPX = 814;
	private int lblPY = 321;
	private JTextArea textArea;
	private JLabel lbli;
	private final Action action = new SwingAction();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()    {
			public void run() {
				try {
					Main frame = new Main(0, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void oneTurn(Player p, Square[] s){
		lblPic_1.setIcon(new ImageIcon(p.getColour()));
		int i = (int) (Math.random() * 5) + 1;
		
		if(i == 1){
			lbli.setIcon(new ImageIcon("input/pictures/Ace.png"));
		}else if(i == 2){
			lbli.setIcon(new ImageIcon("input/pictures/Two.png"));
		}else if(i == 3){
			lbli.setIcon(new ImageIcon("input/pictures/Three.png"));
		}else if(i == 4){
			lbli.setIcon(new ImageIcon("input/pictures/Four.png"));
		}else if(i == 5){
			lblP[i].setIcon(new ImageIcon("input/pictures/Trump22.png"));
		}
		
		movePlayer(i,p.getCurrentSquare(), true, s, p.getID());
		
		if(s[p.getCurrentSquare()].isChance()){
			
			
			
			
		}
		
	}
	
	public void movePlayer(int squares, int square, boolean forward, Square[] s, int currentPlayer){
		
		if(forward){
			lblP[currentPlayer].setBounds(s[square+squares].getX(), s[square+squares].getY(), 22, 22);	
			revalidate();
		}else{
			lblP[currentPlayer].setBounds(s[square-squares].getX(), s[square-squares].getY(), 22, 22);
			revalidate();
		}
		if(s[square].isHub()){
			ArrayList<Player> temp = null;
			if(forward){
				if(!s[square+square].isHub())
					temp = s[squares+square].getPlayer();
				for(int i = 0; i < s[square].getPlayer().size(); i++)
					if(s[square].getPlayer().get(i).getID() == currentPlayer)
						s[square+squares].addPlayer(s[square].getPlayer().get(i));
			}else{
				if(!s[square+square].isHub())
					temp = s[squares+square].getPlayer();
				for(int i = 0; i < s[square].getPlayer().size(); i++)
					if(s[square].getPlayer().get(i).getID() == currentPlayer)
						s[square-squares].addPlayer(s[square].getPlayer().get(i));
				
			}
			s[square].clearPlayer(0);	
			s[square].setPlayers(temp);
			
		}else{
			ArrayList<Player> temp = null;
			if(forward){
				if(!s[square+square].isHub())
					temp = s[squares+square].getPlayer();
				s[square+squares].addPlayer(s[square].getPlayer().get(0));
			}else{
				if(!s[square+square].isHub())
					temp = s[squares+square].getPlayer();
				s[square-squares].addPlayer(s[square].getPlayer().get(0));
			}
			s[square].clearPlayer(0);
			s[square].setPlayers(temp);
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Main(int numberOfPlayers, Player[] p) {
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
		
		lblPic_1 = new JLabel("pic");
		lblPic_1.setIcon(new ImageIcon("input/pictures/Trump.png"));
		lblPic_1.setBounds(1031, 52, 113, 111);
		contentPane.add(lblPic_1);
		
		lbli = new JLabel("i");
		
		lbli.setBounds(1195, 16, 113, 160);
		contentPane.add(lbli);
		
		
		for(int i=0; i<numberOfPlayers; i++){
		lblP[i] = new JLabel("p1");
		lblP[i].setIcon(new ImageIcon(p[i].getColour()));
		lblP[i].setBounds(754, 321, 22, 22);
		contentPane.add(lblP[i]);
		
		}
		
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
			
			
		}
	}
}
