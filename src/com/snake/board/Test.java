package com.snake.board;
import java.util.Random;
import com.snake.board.util.BoardGame;

/**
 * <p>Main class to test the game</p>
 * @author Cristian
 *
 */
public class Test{	
	
	public static void main(String args[]){
		String arr[][] = new String[6][7];		
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				arr[i][j] = String.valueOf(new Random().nextInt(2));			
			}			
		}		
		
		BoardGame boardGame = new BoardGame(arr);
		boardGame.printBoard();	
		
		boolean winner = boardGame.checkWinHor("0");
		boolean winnerV = boardGame.checkWinVert("0");
		boolean winnerRC = boardGame.checkWinRightCorner(0, 3, 4, "0");
		boolean winnerLC = boardGame.checkWinLeftCorner(0, 3, 4, "0");
		
		System.out.println();
		
		if(winnerLC){
			System.out.println("Solución encontrada, diagonal izquierda a derecha");
		}
		
		if(winnerRC){
			System.out.println("Solución encontrada, diagonal derecha a izquierda");
		}
		
		if(winnerV){
			System.out.println("Solución encontrada, vertical");
		}
		
		if(winner){
			System.out.println("Solución encontrada, horizontal");
		}		
				
	}
}
