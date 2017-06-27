package com.snake.board.util;

/**
 * <p>Class to check if exist a solution</p>
 * @author Cristian
 *
 */
public class BoardGame{
	private int row;
	private int column;
	private int loopCount;
	private String table[][];
	
	public BoardGame(String table[][]){
		this.row = 7;
		this.column = 6;
		this.table = table;
	}
	
	
	public void printBoard(){
		System.out.println("Imprimiendo tablero");
		for(int i = 0; i < this.table.length; i++){
			System.out.println();
			for(int j = 0; j < this.table[0].length;j++){
				System.out.print(this.table[i][j] + " ");			
			}
		}
		System.out.println();
	}
	
	/**
	 * <p>Check if exist a solution in the rows</p>
	 * @param player
	 * @return true if exist
	 */
	public boolean checkWinHor(String player){
		int count = 0;		
		for(int i = 0; i < this.table.length; i++){			
			for(int j = 0; j < this.table[0].length; j++){
				if(this.table[i][j].equals(player) && j < this.table[0].length){
					if(j == 0){
						count = 0;
					}else{
						count++;
					}
										
					if(count == 4){
						return true;
					}
				}else{
					count = 0;
				}
			}			
		}		
		return false;
	}
	
	/**
	 * <p>Check if exist a solution in the columns</p>
	 * @param player
	 * @return true if exist
	 */
	public boolean checkWinVert(String player){
		int count = 0;		
		for(int i = 0; i < this.table[0].length; i++){			
			for(int j = 0; j < this.table.length;j++){
				if(this.table[j][i].equals(player) && i < this.table[0].length){
					if(j == 5){
						count = 0;
					}else{
						count++;
					}
					
					if(count == 4){
						return true;
					}
				}else{
					count = 0;
				}							
			}
		}
		return false;
	}
	
	/**
	 * <p>Check if exist a solution in diagonal, from right corner to left</p>
	 * @param row
	 * @param column
	 * @param loopCount
	 * @param player
	 * @return true if exist
	 */
	public boolean checkWinRightCorner(int row, int column, int loopCount, String player){		
		int aux = 0;		
		this.row = row;
		this.column = column;
		this.loopCount = loopCount;
		System.out.println("Diagonal values, corner right to left");
		
		while(aux < 6){
			System.out.println("");
			int count = 0;
			for(int i = this.row; i < this.loopCount; i++){
				System.out.println(this.table[i][this.column]);
				if(this.table[i][this.column].equals(player)){
					count++;
					if(count == 4){
						return true;
					}
				}else{
					count = 0;
				}
				
				this.column--;
			}
			
			aux++;
			updateValuesRightCorner(aux);
		}
		
		return false;		
	}
	
	/**
	 * <p>Check if exist a solution in diagonal, from left corner to right</p>
	 * @param row
	 * @param column
	 * @param loopCount
	 * @param player
	 * @return
	 */
	public boolean checkWinLeftCorner(int row, int column, int loopCount, String player){		
		int aux = 0;		
		this.row = row;
		this.column = column;
		this.loopCount = loopCount;
		System.out.println("Diagonal values, corner left to right");
		while(aux < 6){
			System.out.println("");
			int count = 0;
			for(int i = this.row; i < this.loopCount; i++){
				System.out.println(this.table[i][this.column]);
				if(this.table[i][this.column].equals(player)){
					count++;
					if(count == 4){
						return true;
					}
				}else{
					count = 0;
				}
				
				this.column++;
			}
			
			aux++;
			updateValuesLeftCorner(aux);
		}
		
		return false;		
	}	
	
	/**
	 * <p>Update the row and column to get the next values</p>
	 * @param aux
	 */
	private void updateValuesLeftCorner(int aux){
		switch(aux){
			case 1:
				this.row = 0;
				this.column = 2;
				this.loopCount = 5;
				break;
				
			case 2:
				this.row = 0;
				this.column = 1;
				this.loopCount = 6;
				break;
				
			case 3:
				this.row = 0;
				this.column = 0;
				this.loopCount = 6;
				break;
				
			case 4:
				this.row = 1;
				this.column = 0;
				this.loopCount = 6;
				break;
				
			case 5:
				this.row = 2;
				this.column = 0;
				this.loopCount = 6;
				break;
	
			default:
				break;
		}
	}
	
	/**
	 * <p>Update the row and column to get the next values</p>
	 * @param aux
	 */
	private void updateValuesRightCorner(int aux){
		switch(aux){
			case 1:
				this.row = 0;
				this.column = 4;
				this.loopCount = 5;
				break;
				
			case 2:
				this.row = 0;
				this.column = 5;
				this.loopCount = 6;
				break;
				
			case 3:
				this.row = 0;
				this.column = 6;
				this.loopCount = 6;
				break;
				
			case 4:
				this.row = 1;
				this.column = 6;
				this.loopCount = 6;
				break;
				
			case 5:
				this.row = 2;
				this.column = 6;
				this.loopCount = 5;
				break;
	
			default:
				break;
		}
	}

}
