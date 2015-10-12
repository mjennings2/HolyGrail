package com.bayviewglen.something;

import java.util.ArrayList;

public class Square extends Locations{

	public Player player;
	private boolean isChance;
	
	public Square(int xCoord, int yCoord) {
		super(xCoord, yCoord);
	}
	
	public int getX () {
		return super.getX();
	}
	
	public int getY () {
		return super.getY();
	}
	
	public void setPlayer(Player p, Player currentPlayer){
		
		this.player = null;
		this.player = p;
		
	}
	
	public Player getPlayer () {
		return this.player;
	}
	
	
	public boolean isChance () {
		return this.isChance;
	}
	
	public void setIsChance(boolean x){
		isChance = x;
	}
	
	public void playerArriving(Player currentPlayer, int currentSquare, Locations[] board){
		
		if(this.player != null){
			this.player.setCurrentSquare(currentSquare);
		}
		
		board[currentSquare].setPlayer(this.player, currentPlayer);
		this.player = currentPlayer;
		
	}
	
	

}
