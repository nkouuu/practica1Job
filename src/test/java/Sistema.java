import  org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import es.codeurjc.ais.tictactoe.Connection;
import es.codeurjc.ais.tictactoe.Player;
import es.codeurjc.ais.tictactoe.TicTacToeGame.*;
import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerResult;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import es.codeurjc.ais.tictactoe.*;
import static org.junit.Assert.*;

public class Sistema {
	
	WebDriver driver,driver2;
	String url="http://localhost:8080/";
	WebElement [] board,board2;
	@BeforeClass
	public static void setupClass() { 
		ChromeDriverManager.getInstance().setup();
		WebApp.start();

	   }
	
	@Before
	public void setup() throws InterruptedException {
		driver= new ChromeDriver();
		driver2= new ChromeDriver();
		driver.get(url);
		driver2.get(url);
		Thread.sleep(2000);
		driver.findElement(By.id("nickname")).sendKeys("nico");
		driver2.findElement(By.id("nickname")).sendKeys("sergio");
		driver.findElement(By.id("startBtn")).click();
		driver2.findElement(By.id("startBtn")).click();
		Thread.sleep(2000);
		board = new WebElement[9];
		board2 = new WebElement[9];
		for (int i=0; i<9; i++) {
			board[i] = driver.findElement(By.id("cell-"+i));
			board2[i] = driver2.findElement(By.id("cell-"+i));
		}
		
	}

	@Test
	public void playerWinsTest() throws InterruptedException {
		
		board[0].click();
		Thread.sleep(1000);
		
		board2[6].click();
		Thread.sleep(1000);
		board[2].click();
		Thread.sleep(1000);
		board2[7].click();
		Thread.sleep(1000);
		board[1].click();
		Thread.sleep(1000);
		assertEquals(driver.switchTo().alert().getText(),"nico wins! sergio looses.");
		assertEquals(driver2.switchTo().alert().getText(),"nico wins! sergio looses.");
		
		
	}
	
	@Test
	public void player2WinsTest() throws InterruptedException {
		
		board[6].click();
		Thread.sleep(1000);
		
		board2[0].click();
		Thread.sleep(1000);
		board[3].click();
		Thread.sleep(1000);
		board2[2].click();
		Thread.sleep(1000);
		board[4].click();
		Thread.sleep(1000);
		board2[1].click();
		Thread.sleep(1000);
		assertEquals(driver.switchTo().alert().getText(),"sergio wins! nico looses.");
		assertEquals(driver2.switchTo().alert().getText(),"sergio wins! nico looses.");
		
		
	}
	
	@Test
	public void drawTest() throws InterruptedException {
		
		board[0].click();
		Thread.sleep(1000);
		
		board2[4].click();
		Thread.sleep(1000);
		board[8].click();
		Thread.sleep(1000);
		board2[1].click();
		Thread.sleep(1000);
		board[7].click();
		Thread.sleep(1000);
		board2[6].click();
		Thread.sleep(1000);
		board[2].click();
		Thread.sleep(1000);
		board2[5].click();
		Thread.sleep(1000);
		board[3].click();
		Thread.sleep(1000);
		assertEquals(driver.switchTo().alert().getText(),"Draw!");
		assertEquals(driver2.switchTo().alert().getText(),"Draw!");
		
		
	}
	
	@After
	public void closeBrowser() throws Exception {
		driver.quit();
		driver2.quit();
	}
	@AfterClass
	public static void closeApp() throws Exception {
		WebApp.stop();
	}
}
