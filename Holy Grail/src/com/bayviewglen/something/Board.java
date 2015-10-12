	package com.bayviewglen.something;

public class Board {

	public Locations[] board = new Locations[72];
	
	
	public static void main(String[] args) {
		Player [] p = {new Player("", "", "p1", false, false, 0)};
		Locations[] board = new Locations[72];
		board[0]= new Hub (814,321, p, false);
		board[1]= new Square (756,321);
		board[2]= new Square (732,321);
		board[3]= new Square (709,321);
		board[4]= new Square (685,321);
		board[5]= new Square (685,296);
		board[6]= new Square (685,272);
		board[7]= new Square (685,246);
		board[8]= new Square (685,222);
		board[9]= new Square (685,200);
		board[10]= new Square (685,173);
		board[11]= new Square (685,151);
		board[12]= new Square (685,125);
		board[13]= new Square (662,125);
		board[14]= new Square (640,125);
		board[15]= new Square (616,125);
		board[16]= new Square (593,125);
		board[17]= new Square (570,125);
		board[18]= new Square (546,125);
		board[19]= new Square (523,125);
		board[20]= new Square (500,125);
		board[21]= new Square (477,125);
		board[22]= new Square (454,125);
		board[23]= new Square (453,150);
		board[24]= new Square (453,174);
		board[25]= new Square (453,198);
		board[26]= new Square (453,223);
		board[27]= new Square (453,246);
		board[28]= new Square (453,272);
		board[29]= new Square (430,272);
		board[30]= new Square (408,272);
		board[31]= new Square (383,272);
		board[32]= new Square (383,296);
		board[33]= new Hub (383,392, false);
		board[34]= new Square (383,416);
		board[35]= new Square (383,442);
		board[36]= new Square (383,465);
		board[37]= new Square (360,465);
		board[38]= new Square (337,465);
		board[39]= new Square (313,465);
		board[40]= new Square (291,465);
		board[41]= new Square (291,442);
		board[42]= new Square (291,417);
		board[43]= new Square (291,393);
		board[44]= new Square (383,246);
		board[45]= new Square (383,221);
		board[46]= new Square (383,197);
		board[47]= new Square (383,173);
		board[48]= new Square (384,149);
		board[49]= new Square (384,124);
		board[50]= new Square (361,124);
		board[51]= new Square (337,124);
		board[52]= new Square (314,124);
		board[53]= new Square (292,124);
		board[54]= new Square (291,150);
		board[55]= new Square (291,171);
		board[56]= new Square (291,196);
		board[57]= new Square (291,220);
		board[58]= new Square (291,244);
		board[59]= new Square (291,272);
		board[60]= new Square (291,295);		
		board[61]= new Square (291,318);
		board[62]= new Square (291,343);
		board[63]= new Square (291,367);
		board[64]= new Square (268,392);
		board[65]= new Square (244,392);
		board[66]= new Square (222,392);
		board[67]= new Square (197,392);
		board[68]= new Square (175,392);
		board[69]= new Square (150,392);
		board[70]= new Square (129,392);
		board[71]= new Hub (71, 392, true);
	
		Main x = new Main(1, p, board);
		x.setVisible(true);
		x.tester();
		
	}
	
	
	public Board(Player[] p) {

		
		
		
		board[0]= new Hub (814,321, p, false);
		board[1]= new Square (756,321);
		board[2]= new Square (732,321);
		board[3]= new Square (709,321);
		board[4]= new Square (685,321);
		board[5]= new Square (685,296);
		board[6]= new Square (685,272);
		board[7]= new Square (685,246);
		board[8]= new Square (685,222);
		board[9]= new Square (685,200);
		board[10]= new Square (685,173);
		board[11]= new Square (685,151);
		board[12]= new Square (685,125);
		board[13]= new Square (662,125);
		board[14]= new Square (640,125);
		board[15]= new Square (616,125);
		board[16]= new Square (593,125);
		board[17]= new Square (570,125);
		board[18]= new Square (546,125);
		board[19]= new Square (523,125);
		board[20]= new Square (500,125);
		board[21]= new Square (477,125);
		board[22]= new Square (454,125);
		board[23]= new Square (453,150);
		board[24]= new Square (453,174);
		board[25]= new Square (453,198);
		board[26]= new Square (453,223);
		board[27]= new Square (453,246);
		board[28]= new Square (453,272);
		board[29]= new Square (430,272);
		board[30]= new Square (408,272);
		board[31]= new Square (383,272);
		board[32]= new Square (383,296);
		board[33]= new Hub (383,392, false);
		board[34]= new Square (383,416);
		board[35]= new Square (383,442);
		board[36]= new Square (383,465);
		board[37]= new Square (360,465);
		board[38]= new Square (337,465);
		board[39]= new Square (313,465);
		board[40]= new Square (291,465);
		board[41]= new Square (291,442);
		board[42]= new Square (291,417);
		board[43]= new Square (291,393);
		board[44]= new Square (383,246);
		board[45]= new Square (383,221);
		board[46]= new Square (383,197);
		board[47]= new Square (383,173);
		board[48]= new Square (384,149);
		board[49]= new Square (384,124);
		board[50]= new Square (361,124);
		board[51]= new Square (337,124);
		board[52]= new Square (314,124);
		board[53]= new Square (292,124);
		board[54]= new Square (291,150);
		board[55]= new Square (291,171);
		board[56]= new Square (291,196);
		board[57]= new Square (291,220);
		board[58]= new Square (291,244);
		board[59]= new Square (291,272);
		board[60]= new Square (291,295);		
		board[61]= new Square (291,318);
		board[62]= new Square (291,343);
		board[63]= new Square (291,367);
		board[64]= new Square (268,392);
		board[65]= new Square (244,392);
		board[66]= new Square (222,392);
		board[67]= new Square (197,392);
		board[68]= new Square (175,392);
		board[69]= new Square (150,392);
		board[70]= new Square (129,392);
		board[71]= new Hub (71, 392, true);
		


		
	}

}
