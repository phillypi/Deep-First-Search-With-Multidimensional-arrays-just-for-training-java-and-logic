package util;

public abstract class ArrayUtil{
	
	
	public static int[] positionArrayNull(int[][] array) {	
		
		for(int column = 0 ; column < 3; column++) {
			for(int line = 0; line < 3; line++) {
				if(array[column][line] == 0) {
					return new int[] {column, line};
				}
			}
		}
		return null;
	}
	
	/* Array equals comparison*/
	public static boolean equals(int[][] source, int[][] goalState) {

		for(int column = 0 ; column < 3; column++) {
			for(int line = 0; line < 3; line++) {
				
				if(source[column][line] != goalState[column][line]) {
					return false;
				}
			}
		}
		return true;
	}
	
	/* ArrayCopy */
	
	public static int[][] arrayCopy(int[][]array){
	
		int[][] newArray = new int[3][3];
	
		for(int column = 0 ; column < 3; column++) {
			for(int line = 0; line < 3; line++) {
				newArray[column][line] = 
							array[column][line]; 
			}
		}
		return newArray;
	}
	
	public static void showArray(int[][] array) {
		for(int i = 0 ; i<3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------");
		
	}
	
	/* From Center Cell Moves*/
	
	public static int[][] moveNullCellCenterToTopMiddle(int[][] array){ //ok
		array[1][1] = array[0][1];
		array[0][1] = 0;
		
		return array;
	}
	
	public static int[][] moveNullCellCenterToMiddleLeft(int[][] array){ 
		array[1][1] = array[1][0];
		array[1][0] = 0;
		
		return array;
	}
	
	public static int[][] moveNullCellCenterToMiddleRight(int[][] array){ 
		array[1][1] = array[1][2];
		array[1][2] = 0;
		
		return array;
	}
	
	public static int[][] moveNullCellCenterToMiddleBotton(int[][] array){
		array[1][1] = array[2][1];
		array[2][1] = 0;
		
		return array;
	}

	public static int[][] moveNullCellBottonMiddleToCenter(int[][] array){ 
		array[2][1] = array[1][1];
		array[1][1] = 0;
		
		return array;
	}
	
	/* Botton Right cell moves */
	public static int[][] moveNullCellBottonRightToMiddleRight(int[][] array){
		array[2][2] = array[1][2];
		array[1][2] = 0;
		
		return array;
	}
	
	public static int[][] moveNullCellBottonRightToBottonMiddle(int[][] array){
		array[2][2] = array[2][1];
		array[2][1] = 0;

		return array;
	}
	
	/*Top right cell moves*/
	public static int[][] moveNullCellTopRightToMiddleRight(int[][] array){ 
		array[0][2] = array[1][2];
		array[1][2] = 0;

		return array;
	}
	
	public static int[][] moveNullCellTopRightToTopMiddle(int[][] array){
		array[0][2] = array[0][1];
		array[0][1] = 0;

		return array;
	}
	
	
	/*Botton left cell moves*/
	public static int[][] moveNullCellBottonLeftToMiddleLeft(int[][] array){
		array[2][0] = array[1][0];
		array[1][0] = 0;
		
		return array;
	}
	
	public static int[][] moveNullCellBottonLeftToBottonMiddle(int[][] array){ 
		array[2][0] = array[2][1];
		array[2][1] = 0;

		return array;
	}
	
	/*Top left cell moves*/
	public static int[][] moveNullCellTopLeftToMiddleLeft(int[][] array){
		array[0][0] = array[1][0];
		array[1][0] = 0;

		return array;
	}
	
	public static int[][] moveNullCellTopLeftToTopMiddle(int[][] array){ 
		array[0][0] = array[0][1];
		array[0][1] = 0;

		return array;
	}
	
	/*Middle Botton cell moves*/
	public static int[][] moveNullCellCenterToBottonMiddle(int[][] array){ 
		array[1][1] = array[2][1];
		array[2][1] = 0;

		return array;
	}
	
	public static int[][] moveNullCellBottonMiddleToBottonLeft(int[][] array){ 
		array[2][1] = array[2][0];
		array[2][0] = 0;

		return array;
	}
	
	public static int[][] moveNullCellBottonMiddleToBottonRight(int[][] array){ 
		array[2][1] = array[2][2];
		array[2][2] = 0;

		return array;
	}
	
	/*Top Middle null cell moves*/
	
	public static int[][] moveNullCellTopMiddleToCenter(int[][] array){ 
		array[0][1] = array[1][1];
		array[1][1] = 0;
		
		return array;
	}
	
	public static int[][] moveNullCellTopMiddleToTopLeft(int[][] array){ 
		array[0][1] = array[0][0];
		array[0][0] = 0;

		return array;
	}
	
	public static int[][] moveNullCellTopMiddleToTopRight(int[][] array){ 
		array[0][1] = array[0][2];
		array[0][2] = 0;
		
		return array;
	}
	
	/*Middle Right null cell moves*/
	
	public static int[][] moveNullCellMiddleRightToCenter(int[][] array){
		array[1][2] = array[1][1];
		array[1][1] = 0;
		
		return array;
	}
	
	public static int[][] moveNullCellMiddleRightToTopRight(int[][] array){ 
		array[1][2] = array[0][2];
		array[0][2] = 0;

		return array;
	}
	
	public static int[][] moveNullCellMiddleRightToBottonRight(int[][] array){ 
		array[1][2] = array[2][2];
		array[2][2] = 0;

		return array;
	}
	
	/* Middle left null cell moves*/
	
	public static int[][] moveNullCellMiddleLeftToCenter(int[][] array){
		array[1][0] = array[1][1];
		array[1][1] = 0;
		
		return array;
	}
	
	public static int[][] moveNullCellMiddleLeftToTopLeft(int[][] array){ 
		array[1][0] = array[0][0];
		array[0][0] = 0;

		return array;
	}
	
	public static int[][] moveNullCellMiddleLeftToBottonLeft(int[][] array){ 
		array[1][0] = array[2][0];
		array[2][0] = 0;

		return array;
	}
	

}
