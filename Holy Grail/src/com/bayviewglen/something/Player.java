package com.bayviewglen.something;

public class Player {

	private String colour;
	private String name;
	private boolean didNothing;
	private boolean atEnd;
	
	public Player(String colour, String name, boolean didNothing, boolean atEnd) {
		
		this.colour = colour;
		this.name = name;
		this.didNothing = didNothing;
		this.atEnd = atEnd;
		
	}
	
	public String getColour () {
		return this.colour;
	}
	
	public void setColour (String colour) {
		this.colour = colour;
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
