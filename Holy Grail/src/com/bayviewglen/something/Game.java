package com.bayviewglen.something;

public class Game {
	
	private Board board;
	private Player[] players;
	private int goesFirst;
	
	public Game(Board board, Player[] players, int goesFirst) {
		this.board = board;
		this.players = players;
		this.goesFirst = goesFirst;
	}

}
