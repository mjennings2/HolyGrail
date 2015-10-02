package com.bayviewglen.something;

public class HolyPotatoes {

	public static void main(String[] args) {
		
		Intro intro = new Intro();
		intro.setVisible(true);
		intro.loop();
		
		PlayerSelection pS = new PlayerSelection();
		pS.frame.setVisible(true);
		int numberOfPlayers = pS.getNumber();
		
		Player p[] = new Player[numberOfPlayers];
		for(int i = 0; i <numberOfPlayers; i++){
			p[i] = new Player(null, null, "Player " + (i+1), false, false, i);
			
		}
		
		PlayerSelectionIcons pSI = new PlayerSelectionIcons(p);
		pSI.frame.setVisible(true);
		pSI.getPlayerIcons(p);
		
		Board board = new Board(p);
		
		Main x = new Main(numberOfPlayers, p, board.squares);
		x.setVisible(true);
		
	
		while(true){
			for(int i = 0; i < p.length; i++){
				x.waiter();
				x.oneTurn(p[i], board.squares, p);	
				
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
