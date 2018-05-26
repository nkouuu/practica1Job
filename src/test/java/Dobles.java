 import static org.mockito.Mockito.*;

import static org.mockito.hamcrest.MockitoHamcrest.*;


import  org.junit.*;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentCaptor.*;

import es.codeurjc.ais.tictactoe.Connection;
import es.codeurjc.ais.tictactoe.Player;
import es.codeurjc.ais.tictactoe.TicTacToeGame.*;
import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerResult;
import es.codeurjc.ais.tictactoe.*;
import org.hamcrest.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Dobles {
	TicTacToeGame game;
	Connection c,c2;
	
	@Before
	public void setup(){
		game=new TicTacToeGame();
		c= mock(Connection.class);
	    c2= mock(Connection.class);
	}
	
	@Test
	public void  playerWinsDoubleTest(){
		game.addConnection(c);
		game.addConnection(c2);
		Player p=new Player(1,"O","jugador1");
		Player p2=new Player(2,"X","jugador2");
		game.addPlayer(p);
		verify(c).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(p)));
		verify(c2).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(p)));
		reset(c);
		reset(c2);
		game.addPlayer(p2);
		
		verify(c).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItem(p2)));
		verify(c2).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems( p2)));
		
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p));
		game.mark(0);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p2));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p2));
		reset(c);
		reset(c2);
		game.mark(3);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p));
		reset(c);
		reset(c2);
		game.mark(1);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p2));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p2));
		reset(c);
		reset(c2);
		game.mark(6);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p));
		reset(c);
		reset(c2);
		game.mark(2);
		
		
		WinnerResult w=game.checkWinner();
		/*verify(c).sendEvent(EventType.GAME_OVER);
		verify(c2).sendEvent(EventType.GAME_OVER);*/
		ArgumentCaptor<WinnerValue> argument =
	            ArgumentCaptor.forClass(WinnerValue.class);
	          verify(c).sendEvent(eq(EventType.GAME_OVER), argument.capture());
	          verify(c2).sendEvent(eq(EventType.GAME_OVER), argument.capture());
	          WinnerValue event = argument.getValue();
	     for(int i=0;i<2;i++) {
	    	 	assertEquals(event.getPos()[i],w.getPos()[i]);
	     }
	}
	
	@Test
	public void  player2WinsDoubleTest(){
		game.addConnection(c);
		game.addConnection(c2);
		Player p=new Player(1,"O","jugador1");
		Player p2=new Player(2,"X","jugador2");
		game.addPlayer(p);
		verify(c).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(p)));
		verify(c2).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(p)));
		reset(c);
		reset(c2);
		game.addPlayer(p2);
		
		verify(c).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItem(p2)));
		verify(c2).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems( p2)));
		
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p));
		game.mark(3);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p2));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p2));
		reset(c);
		reset(c2);
		game.mark(0);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p));
		reset(c);
		reset(c2);
		game.mark(6);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p2));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p2));
		reset(c);
		reset(c2);
		game.mark(1);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p));
		reset(c);
		reset(c2);
		game.mark(4);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p2));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p2));
		reset(c);
		reset(c2);
		game.mark(2);
		
		
		WinnerResult w=game.checkWinner();
		
		ArgumentCaptor<WinnerValue> argument =
	            ArgumentCaptor.forClass(WinnerValue.class);
	          verify(c).sendEvent(eq(EventType.GAME_OVER), argument.capture());
	          verify(c2).sendEvent(eq(EventType.GAME_OVER), argument.capture());
	          WinnerValue event = argument.getValue();
	     for(int i=0;i<2;i++) {
	    	 	assertEquals(event.getPos()[i],w.getPos()[i]);
	     }
	}
	
	@Test
	public void drawDoubleTest(){
		game.addConnection(c);
		game.addConnection(c2);
		Player p=new Player(1,"O","jugador1");
		Player p2=new Player(2,"X","jugador2");
		game.addPlayer(p);
		verify(c).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(p)));
		verify(c2).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(p)));
		
		reset(c);
		reset(c2);
		game.addPlayer(p2);
		verify(c).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(p2)));
		verify(c2).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(p2)));
		reset(c);
		reset(c2);
		
		game.mark(0);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p2));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p2));
		reset(c);
		reset(c2);
		
		game.mark(4);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p));
		reset(c);
		reset(c2);
		game.mark(8);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p2));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p2));
		reset(c);
		reset(c2);
		game.mark(1);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p));
		reset(c);
		reset(c2);
		game.mark(7);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p2));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p2));
		reset(c);
		reset(c2);
		game.mark(6);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p));
		reset(c);
		reset(c2);
		game.mark(2);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p2));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p2));
		reset(c);
		reset(c2);
		game.mark(5);
		verify(c).sendEvent(eq(EventType.SET_TURN), eq(p));
		verify(c2).sendEvent(eq(EventType.SET_TURN), eq( p));
		reset(c);
		reset(c2);
		game.mark(3);
		
		assertTrue(game.checkDraw());
		ArgumentCaptor<WinnerValue> argument =
				ArgumentCaptor.forClass(WinnerValue.class);
	    verify(c).sendEvent(eq(EventType.GAME_OVER), argument.capture());
	    verify(c2).sendEvent(eq(EventType.GAME_OVER), argument.capture());
	    WinnerValue event = argument.getValue();
		
		
		assertNull(event);
		
		
		
		
	}
	
}
