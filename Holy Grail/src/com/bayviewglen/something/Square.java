package com.bayviewglen.something;

import java.util.ArrayList;

public class Square {

	private int x;
	private int y;
	public ArrayList<Player> players = new ArrayList<Player>();
	private boolean isChance;
	private boolean isHub;
	private boolean isEnd;
	
	public Square(int xCoord, int yCoord, Player[] player, boolean isHub, boolean isEnd) {
		this.x = xCoord;
		this.y = yCoord;
		for(int i = 0; i < player.length; i++)
			players.add(player[i]);
		this.isChance = false;
		this.isHub = isHub;
		this.isEnd = isEnd;
		
	}
	
	public Square(int xCoord, int yCoord, boolean isHub, boolean isEnd) {
		this.x = xCoord;
		this.y = yCoord;
		this.isChance = isChance;
		this.isHub = isHub;
		this.isEnd = isEnd;
		
	}
	
	public void clearPlayer(int x){
		for(int i = 0; i < players.size(); i++)
			if(players.get(i).getID() == x)
				this.players.remove(i);
	}
	
	public int getX () {
		return this.x;
	}
	
	public int getY () {
		return this.y;
	}
	
	public void setPlayers(ArrayList<Player> plasyers){
		
		this.players = players;
		
	}
	
	public ArrayList<Player> getPlayer () {
		return this.players;
	}
	
	public void addPlayer (Player[] player) {
		for(int i = 0; i < player.length; i++)
			players.add(player[i]);
	}
	
	public void addPlayer (Player player) {
		players.add(player);
	}
	
	public boolean isChance () {
		return this.isChance;
	}
	
	public void setIsChance(boolean x){
		isChance = x;
	}
	
	public boolean isHub () {
		return this.isHub;
	}
	
	public boolean isEnd () {
		return this.isEnd;
	}

}
