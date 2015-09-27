package com.bayviewglen.something;

public class Player {

	private String colour;
	private String colourSmall;
	private String name;
	private boolean didNothing;
	private boolean atEnd;
	private int playerID;
	private int currentSquare;
	
	public Player(String colour, String colourSmall, String name, boolean didNothing, boolean atEnd, int playerID) {
		this.colourSmall = colourSmall;
		this.colour = colour;
		this.name = name;
		this.didNothing = didNothing;
		this.atEnd = atEnd;
		this.playerID = playerID;
		this.currentSquare = 0;
	}
	
	
	
	public String getColourSmall() {
		return colourSmall;
	}



	public void setColourSmall(String colourSmall) {
		this.colourSmall = colourSmall;
	}



	public int getPlayerID() {
		return playerID;
	}



	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}



	public int getCurrentSquare() {
		return currentSquare;
	}



	public void setCurrentSquare(int currentSquare) {
		this.currentSquare = currentSquare;
	}



	public String getColour () {
		return this.colour;
	}
	
	public void setColour (String colour) {
		this.colour = colour;
	}
	
	public int getID() {
		return this.playerID;
	}
	
	public String getName () {
		return this.name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public boolean getAction () {
		return this.didNothing;
	}
	
	public void setAction (boolean action) {
		this.didNothing = action;
	}
	
	public boolean isWinner () {
		return this.atEnd;
	}
	
	public void hasWon (boolean atEnd) {
		this.atEnd = atEnd;
	}

}
