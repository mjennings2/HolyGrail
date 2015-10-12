package com.bayviewglen.something;

import java.util.ArrayList;

public class Hub extends Locations{

	public ArrayList<Player> players = new ArrayList<Player>();
	private boolean isEnd;
	
	public Hub(int xCoord, int yCoord, Player[] player, boolean isEnd) {
		super(xCoord, yCoord);
		for(int i = 0; i < player.length; i++)
			players.add(player[i]);
		this.isEnd = isEnd;	
	}
	
	public Hub(int xCoord, int yCoord, boolean isEnd) {
		super(xCoord, yCoord);
		this.isEnd = isEnd;	
	}
	
	public void clearPlayer(int x){
		for(int i = 0; i < players.size(); i++)
			if(players.get(i).getID() == x)
				this.players.remove(i);
	}
	
	public int getX () {
		return super.getX();
	}
	
	public int getY () {
		return super.getY();
	}
	
	public void setPlayer(Player player, Player currentPlayer){
		
		for(int i = 0; i < players.size(); i++){
			try{
			if(players.get(i).getID() == currentPlayer.getID()){
				players.remove(i);
				i += players.size(); 
			}
			}catch(NullPointerException e){
				
			}
		}
		
		players.add(player);
		
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
	
	public boolean isEnd () {
		return this.isEnd;
	}

	public void playerArriving(Player currentPlayer, int currentSquare, Locations[] board){
		
		players.add(currentPlayer);
		
	}
	
}
