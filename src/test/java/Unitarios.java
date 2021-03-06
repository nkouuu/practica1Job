import  org.junit.*;

import es.codeurjc.ais.tictactoe.Board;

import static org.junit.Assert.*;


public class Unitarios {
	
	Board board;
	
	@Before
	public void setup(){
		
		board=new Board(); 
		
	}
	@Test
	public void playerWinsTest(){
		assertNull(board.getCellsIfWinner("o"));
		board.getCell(0).setValue("o");
		board.getCell(5).setValue("x");
		board.getCell(1).setValue("o");
		board.getCell(8).setValue("x");
		board.getCell(2).setValue("o");
		int[] i={0,1,2};
		assertNotNull(board.getCellsIfWinner("o"));
		assertArrayEquals(board.getCellsIfWinner("o"),i);
		
	}
	@Test
	public void player2WinsTest(){
		assertNull(board.getCellsIfWinner("o"));
		board.getCell(0).setValue("x");
		board.getCell(3).setValue("o");
		board.getCell(1).setValue("x");
		board.getCell(8).setValue("o");
		board.getCell(2).setValue("x");
		board.getCell(6).setValue("o");
		
		int[] i={0,1,2};
		assertNotNull(board.getCellsIfWinner("x"));
		assertArrayEquals(board.getCellsIfWinner("x"),i);
		
	}
	
	@Test
	public void drawTest(){
		assertFalse(board.checkDraw());
		board.getCell(0).setValue("o");
		board.getCell(1).setValue("x");
		board.getCell(2).setValue("o");
		board.getCell(3).setValue("x");
		board.getCell(4).setValue("o");
		board.getCell(5).setValue("x");
		board.getCell(6).setValue("x");
		board.getCell(7).setValue("o");
		board.getCell(8).setValue("x");
		
		assertTrue(board.checkDraw());
		
		
	}
	
	
	
	
}
