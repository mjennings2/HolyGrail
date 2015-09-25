package com.bayviewglen.something;

import java.util.ArrayList;

public class Square {

	private int x;
	private int y;
	private ArrayList<Player> players = new ArrayList<Player>();
	private boolean isChance;
	private boolean isHub;
	private boolean isEnd;
	
	public Square(int xCoord, int yCoord, Player[] player, boolean isChance, boolean isHub, boolean isEnd) {
		this.x = xCoord;
		this.y = yCoord;
		for(int i = 0; i < player.length; i++)
			players.add(player[i]);
		this.isChance = isChance;
		this.isHub = isHub;
		this.isEnd = isEnd;
		
	}
	
	public Square(int xCoord, int yCoord, boolean isChance, boolean isHub, boolean isEnd) {
		this.x = xCoord;
		this.y = yCoord;
		this.isChance = isChance;
		this.isHub = isHub;
		this.isEnd = isEnd;
		
	}
	
	public void clearPlayer(int x){
		if(isHub)
			this.players.remove(x);
		else
			this.players.remove(0);
	}
	
	public int getX () {
		return this.x;
	}
	
	public int getY () {
		return this.y;
	}
	
	public ArrayList<Player> getPlayer () {
		return this.players;
	}
	
	public void addPlayer (Player[] player) {
		for(int i = 0; i < player.length; i++)
			players.add(player[i]);
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
