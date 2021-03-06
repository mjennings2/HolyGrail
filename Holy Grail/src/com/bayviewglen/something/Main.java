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

	private static final int BRIDGE_INT = 31;
	private static final int LONGPATHSTART_INT = 43;
	private static final int ENDPATHSTART_INT = 63;
	public JPanel contentPane;
	private JLabel lblP[] = new JLabel[8];
	private JLabel lblPic_1;
	private int lblPX = 814;
	private int lblPY = 321;
	private JTextArea textArea;
	private JLabel lbli;
	private JLabel chance[] = new JLabel[100];
	private boolean wait;
	private final Action action = new SwingAction();
	
	// TODO JOSH PUT UML
	
	private String imageURL[] = {"input/pictures/Ace.png", "input/pictures/Two.png", "input/pictures/Three.png", "input/pictures/Four.png", "input/pictures/Five.png"};
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	public void play(Player currentPlayer, Locations[] board, Player[] players){
		// Set icon of current player
		lblPic_1.setIcon(new ImageIcon(currentPlayer.getColour()));
		
		// Start of turn, initial move. Moves player forward x squares, x is a random int from 1 to 5
		int i = (int) (Math.random() * 5) + 1;
		lbli.setIcon(new ImageIcon(imageURL[i-1]));
		
		// Change Players's square, and swap with player on future square
		move(currentPlayer, board, players, currentPlayer.getCurrentSquare(), i);
		
		// Check for chance, untill there is no more chance
		boolean loop = true;
		while(loop){
			if(board[currentPlayer.getCurrentSquare()].getClass() != board[0].getClass() && ((Square) board[currentPlayer.getCurrentSquare()]).isChance()){
				
				textArea.append("You have landed on a chance square.");
				CurrentPlayers c = new CurrentPlayers(players);
				c.frame.setVisible(true);
				int chosenPlayer = c.getPlayer(players);
				NumberChooser c1 = new NumberChooser();
				c1.frame.setVisible(true);
				int numberOfSquares = c1.getNumber();
				
				int forwardOrBackward = (int) (Math.random() * 2) + 1;
				if(forwardOrBackward == 1){
					lbli.setIcon(new ImageIcon("input/pictures/Forward.png"));
				}else{
					lbli.setIcon(new ImageIcon("input/pictures/Backward.png"));
					numberOfSquares = 0 - numberOfSquares;
				}	
				
				// Change Players's square, and swap with player on future square
				move(players[chosenPlayer], board, players, players[chosenPlayer].getCurrentSquare(), numberOfSquares);
				
				if(chosenPlayer != currentPlayer.getID())
					loop = false;
				
			}else{
				loop = false;
			}
		
		}
		
		
	}
	
	
	/*public void oneTurn(Player p1, Square[] s,Player[] p){
		lblPic_1.setIcon(new ImageIcon(p1.getColour()));
		int i = (int) (Math.random() * 5) + 1;
		
		if(i == 1){ 	
			lbli.setIcon(new ImageIcon("input/pictures/Ace.png"));
			p1.setCurrentSquare(p1.getCurrentSquare()- i);
		}else if(i == 2){
			lbli.setIcon(new ImageIcon("input/pictures/Two.png"));
			p1.setCurrentSquare(p1.getCurrentSquare()- i);
		}else if(i == 3){
			lbli.setIcon(new ImageIcon("input/pictures/Three.png"));
			p1.setCurrentSquare(p1.getCurrentSquare()- i);
		}else if(i == 4){
			lbli.setIcon(new ImageIcon("input/pictures/Four.png"));
			p1.setCurrentSquare(p1.getCurrentSquare()- i);
		}else if(i == 5){
			lbli.setIcon(new ImageIcon("input/pictures/Five.png"));
			p1.setCurrentSquare(p1.getCurrentSquare()- i);
		}
		
		movePlayer(i,p1.getCurrentSquare()-i, true, s, p1.getID());
		boolean loop = true;
		while(loop){
		if(s[p1.getCurrentSquare()].isChance()&&!s[p1.getCurrentSquare()].isEnd()){
			System.out.println("Hi");
			textArea.append("You have landed on a chance square.");
			CurrentPlayers c = new CurrentPlayers(p);
			c.frame.setVisible(true);
			int player = c.getPlayer(p);
			NumberChooser c1 = new NumberChooser();
			c1.frame.setVisible(true);
			int numberOfSquares = c1.getNumber();
			int forwardOrBackward = (int) (Math.random() * 2) + 1;
			if(forwardOrBackward == 1){
				lbli.setIcon(new ImageIcon("input/pictures/Forward.png"));
			}else{
				lbli.setIcon(new ImageIcon("input/pictures/Backward.png"));
			}
			
			movePlayer(numberOfSquares, p[player].getCurrentSquare(), forwardOrBackward == 1, s, player);
			
			
			
			if(!(p1.getID() == p[player].getID())){
				loop = false;
			}
			
			c1.frame.setVisible(false);
			c.frame.setVisible(false);
			
		}else{
			loop = false;
		}
		}
		
	}
	
	public void movePlayer(int squares, int square, boolean forward, Square[] s, int currentPlayer){
		Player playe = getTempPlayer(s, square, currentPlayer);
				
		boolean onShortPath = (square>BRIDGE_INT&&square<LONGPATHSTART_INT);
		if(square==BRIDGE_INT){
			boolean takeShortPath = getShortOrNot();	
			if(!takeShortPath)
				squares=+LONGPATHSTART_INT-BRIDGE_INT+1;
			else{
				Blackjack game = new Blackjack();	
				squares=game.playBlackJack("Player " + (currentPlayer+1));
			}
		}
		
		
		if(forward&&onShortPath&&square+squares>=LONGPATHSTART_INT)
			squares+=ENDPATHSTART_INT-LONGPATHSTART_INT;
		
		if(!forward&&square>=LONGPATHSTART_INT&&square<ENDPATHSTART_INT&&square-squares<LONGPATHSTART_INT)
			squares=square-BRIDGE_INT;
		
		squares=modifySquares(forward, square, squares, s);
		
		
		
		if(squares!=0)
		if(s[square].isHub()){
			
			if(forward){
				if(!s[squares+square].isHub()){
				
					if(squareOccupied(s[square+squares])){
						movePlayer(squares, square+squares, !forward ,s, s[square+squares].getPlayer().get(0).getID());
					}					
				}	
			
						s[square+squares].addPlayer(playe);
			}else{
				if(!s[square-squares].isHub()){
			
					if(squareOccupied(s[square-squares])){
						movePlayer(squares, square-squares, !forward ,s, s[square-squares].getPlayer().get(0).getID());
					}
				}
						s[square-squares].addPlayer(playe);
				
			}
			if(s[square].players.size() != 0)
				s[square].clearPlayer(currentPlayer);				
		}else{
			
			if(forward){
				if(!s[square+squares].isHub()){
				
					if(squareOccupied(s[square+squares])){
						
						movePlayer(squares, square+squares, !forward ,s, s[square+squares].getPlayer().get(0).getID());
					}
				s[square+squares].addPlayer(playe);
				}else{
					s[square].clearPlayer(currentPlayer);
					s[square+squares].addPlayer(playe);
				}
			}else{
				if(!s[square-squares].isHub()){
					
					if(squareOccupied(s[square-squares])){
						s[square].clearPlayer(currentPlayer);
						movePlayer(squares, square-squares, !forward ,s, s[square-squares].getPlayer().get(0).getID());
					}
				s[square-squares].addPlayer(playe);
					}else{
						s[square].clearPlayer(currentPlayer);
						s[square-squares].addPlayer(playe);
					}
			}

		
		}
		
		if(forward){
			if(square+squares <=22 || (square+squares >= 41 && square+squares <= 53) || (square+squares >= 64 && square+squares <= 71)){
				
				if((square >= 0 && square <= 4) || (square >= 12 && square <= 22) || (square >= 28 && square <= 31) || (square >= 49 && square <= 53) || (square >= 36 && square <= 40) || (square >= 43 && square <= 71)){
				
				for(int j = 1; j <= squares; j++){
					for(int i = s[square+j-1].getX(); i >= s[square+j].getX(); i--){
						lblP[currentPlayer].setBounds(i, s[square].getY(), 22, 22);	
						revalidate();
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					}
				for(int j = 1; j <= squares; j++){
					for(int i = s[square+j-1].getY(); i >= s[square+j].getY(); i--){
						lblP[currentPlayer].setBounds(s[square+squares].getX(), i, 22, 22);		
						revalidate();
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			
				}else{
					
					for(int j = 1; j <= squares; j++){
						for(int i = s[square+j-1].getY(); i >= s[square+j].getY(); i--){
							lblP[currentPlayer].setBounds(s[square+squares].getX(), i, 22, 22);		
							revalidate();
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
					for(int j = 1; j <= squares; j++){
						for(int i = s[square+j-1].getX(); i >= s[square+j].getX(); i--){
							lblP[currentPlayer].setBounds(i, s[square].getY(), 22, 22);	
							revalidate();
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						}
				}
			
			}else{
				
				
				
				
				for(int j = 1; j <= squares; j++){
					for(int i = s[square+j-1].getX(); i <= s[square+j].getX(); i++){
						lblP[currentPlayer].setBounds(i, s[square].getY(), 22, 22);	
						revalidate();
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					}
				for(int j = 1; j <= squares; j++){
					for(int i = s[square+j-1].getY(); i <= s[square+j].getY(); i++){
						lblP[currentPlayer].setBounds(s[square+squares].getX(), i, 22, 22);		
						revalidate();
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				
			}
		}else{
			lblP[currentPlayer].setBounds(s[square-squares].getX(), s[square-squares].getY(), 22, 22);
			revalidate();
		}
		if(forward){
			playe.setCurrentSquare(square + squares);
		}else{
			playe.setCurrentSquare(square - squares);
		}
	}
	*/


	private void move(Player currentPlayer, Locations[] board, Player[] players, int currentSquare, int i) {
		
		// TODO 0.25 Check if on choice square
				
		if(currentSquare <= 43 && currentSquare + i > 43 ){
			i -= 1;
			currentPlayer.setCurrentSquare(64);
			lblP[currentPlayer.getID()].setBounds(board[64].getX(), board[64].getY(), 22, 22);	
			revalidate();
			
			
		}else{
		
		
		
		
		// 0.5 Make sure the players remain with the squares that exist
		// Start
		if(currentSquare + i < 0){
			i -= 0 - (currentSquare + i);
		}
		
		// Finish
		if(currentSquare + i > 72){
			i = 72 - currentSquare;
		}
		
		// Hub
		if(currentSquare + i >= 31 && currentSquare < 31){
			i = 31 - currentSquare;
		}
		if(currentSquare >= 33 && currentSquare + i < 33){
			i = (0-33) + currentSquare;
		}
		if(currentSquare >= 44 && currentSquare + i < 44){
			i = (0-44) + currentSquare;
		}
		
		// 1. Change Players currentSquare
				currentPlayer.setCurrentSquare(currentPlayer.getCurrentSquare() + i);
		
		// 2. Move icons
		animate(currentPlayer.getID(), currentSquare, i, board);

		// If going to a square, and someone is there, move there icon back
		if(board[currentSquare + i].getClass() != board[0].getClass() && ((Square)board[currentSquare + i]).getPlayer() != null){
			animate(((Square)board[currentSquare + i]).getPlayer().getID(), currentSquare + i, 0 - i, board);
		}
			
		// 3. If the square currentPlayer is going to is not a hub, change the currentSquare of the player on that square to the original currentPlayer's square
		board[currentSquare + i].playerArriving(currentPlayer, currentSquare, board);
		}
		
		boolean right = false;
		if(currentSquare + i == 31){
			LeftOrRight leftOrRight = new LeftOrRight();
			leftOrRight.frame.setVisible(true);
			right = leftOrRight.getDir();
			if(right){
				i -= 1;
				board[44].playerArriving(currentPlayer, 31, board);
				currentPlayer.setCurrentSquare(44);
				lblP[currentPlayer.getID()].setBounds(board[44].getX(), board[44].getY(), 22, 22);	
				revalidate();	
				
			}else{
				board[32].playerArriving(currentPlayer, 31, board);
				currentPlayer.setCurrentSquare(32);
				lblP[currentPlayer.getID()].setBounds(board[32].getX(), board[32].getY(), 22, 22);	
				revalidate();
			}
		}
		
		
	}
	
	public void tester(){
		
		
		Player [] p = {new Player("", "", "p1", false, false, 0)};
		Board hi = new Board(p);
		animate(1, 0, 74, hi.board);
		
		
	}
	
	
	
/*
	private Player getTempPlayer(Square[] s, int square, int currentPlayer) {
		
		if(s[square].isHub()){
			for(int i = 0; i < s[square].getPlayer().size(); i++)
				if(s[square].getPlayer().get(i).getID() == currentPlayer)
			return s[square].getPlayer().get(i);
		}
		return s[square].getPlayer().get(0);
	}

	private boolean squareOccupied(Square square) {
		
		return square.getPlayer().size()!=0;
	}

	private int modifySquares(boolean forward, int square, int squares, Square[] s) {
		for(int i = squares; i>0; i--){
			if(forward){
				if(square- i>=s.length){
					squares=s.length-1-square;
				}					
				else if(s[square- i].isEnd()||s[square- i].isHub())				
					squares = i;
			}
			else{
				if(square-i<0)
					squares=0;
				if(square-i>=0&&s[square-i].isHub()){			
					squares = i;
				}
			}
		}
		return squares;
	}
	*/

	
	
	
private void animate(int id, int currentSquare, int squaresToMove, Locations[] board) {
		// TODO Auto-generated method stub
		// If going forward
		if(squaresToMove > 0){
			// Moving square by square
			for(int i = 1; i <= squaresToMove; i++){
				
				//Find out if moving up on the screen (Y coord goes down)
				if(board[currentSquare+ i-1].getY() >= board[currentSquare+ i].getY()){
					// For every x pixel between the squares
					for(int j = board[currentSquare + i - 1].getX(); j >= board[currentSquare + i].getX(); j--){
						// Move label
						lblP[id].setBounds(j, board[currentSquare+ i-1].getY(), 22, 22);	
						revalidate();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// For every y pixel between the squares
					for(int j = board[currentSquare + i - 1].getY(); j >= board[currentSquare + i].getY(); j--){
						// Move label
						lblP[id].setBounds(board[currentSquare+ i].getX(), j, 22, 22);	
						revalidate();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else{
					// For every x pixel between the squares
					for(int j = board[currentSquare + i - 1].getX(); j >= board[currentSquare + i].getX(); j--){
						// Move label
						lblP[id].setBounds(j, board[currentSquare+ i-1].getY(), 22, 22);	
						revalidate();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// For every y pixel between the squares
					for(int j = board[currentSquare + i - 1].getY(); j <= board[currentSquare + i].getY(); j++){
						// Move label
						lblP[id].setBounds(board[currentSquare+ i].getX(), j, 22, 22);	
						revalidate();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			
			}
				
		}else{
			
			// Moving square by square
			for(int i = -1; i >= squaresToMove; i--){
				
				//Find out if moving up on the screen (Y coord goes down)
				if(board[currentSquare+i+1].getY() >= board[currentSquare+i].getY()){
					// For every x pixel between the squares
					for(int j = board[currentSquare + i + 1].getX(); j <= board[currentSquare + i].getX(); j++){
						// Move label
						lblP[id].setBounds(j, board[currentSquare+i+1].getY(), 22, 22);	
						revalidate();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// For every y pixel between the squares
					for(int j = board[currentSquare + i + 1].getY(); j >= board[currentSquare + i].getY(); j--){
						// Move label
						lblP[id].setBounds(board[currentSquare + i].getX(), j, 22, 22);	
						revalidate();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else{
					// For every x pixel between the squares
					for(int j = board[currentSquare + i + 1].getX(); j <= board[currentSquare + i].getX(); j++){
						// Move label
						lblP[id].setBounds(j, board[currentSquare + i + 1].getY(), 22, 22);	
						revalidate();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// For every y pixel between the squares
					for(int j = board[currentSquare + i + 1].getY(); j <= board[currentSquare + i].getY(); j++){
						// Move label
						lblP[id].setBounds(board[currentSquare + i].getX(), j, 22, 22);	
						revalidate();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			
			}
			
		}
		
	
	}

	/*	private boolean getShortOrNot() {
		// TODO Auto-generated method stub
		return false;
	}
*/
	/**
	 * Create the frame.
	 */
	public Main(int numberOfPlayers, Player[] p, Locations[] s) {
		
		
		
		
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
		
		JLabel lblPic = new JLabel("Pic");
		lblPic.setIcon(new ImageIcon("input/pictures/Holy Grail Hunting or Somthing.png"));
		lblPic.setBounds(15, 16, 1001, 534);
		contentPane.add(lblPic);
		
		
		
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
			lblP[i].setIcon(new ImageIcon(p[i].getColourSmall()));
			lblP[i].setBounds(814,371, 22, 22);
			contentPane.add(lblP[i]);
		
		}
		/*
		lblP[1] = new JLabel("p1");
		lblP[1].setIcon(new ImageIcon("input/pictures/Trump.png"));
		lblP[1].setBounds(814,371, 22, 22);
		contentPane.add(lblP[1]);
		
		
		int x = 0;
		for(int i = 0; i < s.length; i++){
			
			
			
			if((int) (Math.random()*100)+1 <= 25){
				
				Square compare = new Square(1, 1);
				if(s[i].getClass() == compare.getClass()){
					chance[x] = new JLabel("");
					chance[x].setIcon(new ImageIcon("input/pictures/chance.png"));
					chance[x].setBounds(s[i].getX(), s[i].getY(), 22, 22);
					contentPane.add(chance[x]);
					x++;
					((Square) s[i]).setIsChance(true);
				}
			}
			
		}
		*/
		
		JButton btnMove = new JButton("Move");
		btnMove.setAction(action);
		btnMove.setBounds(1122, 318, 115, 29);
		contentPane.add(btnMove);
		contentPane.add(lblPic);
	}
	public void waiter(){
		while(!wait){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		wait=false;
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "DO ACTION");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			wait = true;
		}
		
	}
	
}
