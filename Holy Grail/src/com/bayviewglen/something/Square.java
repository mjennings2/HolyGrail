package com.bayviewglen.something;

public class Square {

	private int x;
	private int y;
	private Player[] players;
	private boolean isChance;
	private boolean isHub;
	private boolean isEnd;
	
	public Square(int xCoord, int yCoord, Player[] player, boolean isChance, boolean isHub, boolean isEnd, Player[] players) {
		this.x = xCoord;
		this.y = yCoord;
		this.players = players;
		this.isChance = isChance;
		this.isHub = isHub;
		this.isEnd = isEnd;
		
	}
	
	public Square(int xCoord, int yCoord, boolean isChance, boolean isHub, boolean isEnd) {
		this.x = xCoord;
		this.y = yCoord;
		this.players = null;
		this.isChance = isChance;
		this.isHub = isHub;
		this.isEnd = isEnd;
		
	}
	
	public int getX () {
		return this.x;
	}
	
	public int getY () {
		return this.y;
	}
	
	public Player[] getPlayer () {
		return this.players;
	}
	
	public void setPlayer (Player[] players) {
		this.players = players;
	}
	
	public boolean isChance () {
		return this.isChance;
	}
	
	public boolean isHub () {
		return this.isHub;
	}
	
	public boolean isEnd () {
		return this.isEnd;
	}

}
