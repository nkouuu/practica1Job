import  org.junit.*;
import static org.junit.Assert.*;
import es.codeurjc.ais.tictactoe.Board;

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
