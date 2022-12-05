package PE1;

import java.util.ArrayList;
import java.util.Arrays;

public class PE1 {
	static Maze dogMaze;
	
	/**
	 * This method sets up the maze using the given input argument
	 * @param maze is a maze that is used to construct the dogMaze
	 */
	public void setup(String[][] maze) {
		this.dogMaze = new Maze(maze);
		/* insert your code here to create the dogMaze 
		 * using the input argument. 
		 */
	}

	/**
	 * This method returns true if the number of 
	 * gates in dogMaze >= 2. 
	 * @return it returns true, if enough gate exists (at least 2), otherwise false.
	 */
	public boolean enoughGate() {

		int startRow = 0;
		int startCol = 0;
		int endRows = dogMaze.getMaze().length-1;
		int endCol = dogMaze.getMaze()[0].length-1;

		return countPath(startRow, startCol, endRows, endCol);

	}
	private boolean countPath(int startRow, int startCol, int endRow, int endCol) {
		String storeElement = "";
		int count = 0;

		// last col
		for (int i = startRow + 1; i < endRow; i++){
			storeElement = dogMaze.getMaze()[i][endCol];
			if(storeElement.charAt(3) =='0'){
				count++;
			}
		}
		// first col
		for (int i = endRow - 1; i >= startRow + 1 ; i--){
			storeElement = dogMaze.getMaze()[i][startCol];
			if(storeElement.charAt(1) =='0'){
				count++;
			}
		}
		//last row
		for (int i = endCol - 1; i >= startCol ; i--) {
			storeElement = dogMaze.getMaze()[endRow][i];
			if (storeElement.charAt(2) == '0') {
				count++;
			}
		}
		//first row
		for (int i = startCol; i <= endCol ; i++){
			storeElement = dogMaze.getMaze()[startRow][i];
			if(storeElement.charAt(0) =='0'){
				count++;
			}
		}

		if (count < 2){
			return false;
		}
		return true;


	}




	/**
	 * This method finds a path from the entrance gate to 
	 * the exit gate. 
	 * @param row is the index of the row, where the entrance is.
	 * @param column is the index of the column, where the entrance is.
	 * @return it returns a string that contains the path from the start to the end.
	 * The return value should have a pattern like this (i,j)(k,l),...
	 * The first pair of the output must show the entrance given as the 
	 * input parameter (i.e. (row,column)
	 * No whitespace is allowed in the output.  
	 */

	public static String findPath(int row, int column) {

		ArrayList<String> pathArray = new ArrayList<String>();
		ArrayList<String> pathArrayrerult = new ArrayList<String>();
		int blockedSide = 1;
		
		String pathArrayCheck =  pathTraverse(row, column, blockedSide, pathArray,"",pathArrayrerult);
		
		String path = Arrays.toString(pathArray.toArray());
		path = path.replaceAll(", ","");
		path = path.substring(1,path.length()-1);

		// insert your code here. Change the return value to fit your purpose.
		System.out.println(pathArrayrerult);
		
		return path;
	}

	private static String pathTraverse(int row, int column, int blockedSide,  ArrayList<String> pathArray,String str,ArrayList<String> pathArrayrerult) {
		String [][] dogMaze = 
			{{"1110", "1010", "1010", "1000", "1010","1011"},
				{"1010", "1000", "1001", "0101", "1100", "1001"},
				{"1100", "0011", "0101", "0110", "0011", "0101"},
				{"0101", "1101", "0110", "1001", "1110", "0000"},
				{"0110", "0011", "1110", "0010", "1010", "0011"}};


// String [][] dogMaze0 = 
// {{"1110", "1010", "1010", "1000"},
//   {"1010", "1000", "1001", "0101"},
//   {"1100", "0011", "0101", "0110"},
//   {"0101", "1101", "0110", "1001"},
//   {"0110", "0011", "1110", "0010"},
// };

		String cellVisted = "("+ row + "," + column + ")";
		// if(pathArray.contains(cellVisted)){
		// 	return pathArray;
		// }
		pathArray.add(cellVisted);
		str += cellVisted;
		String val = "";
		// System.out.println(str);

		if (dogMaze[row][column].charAt(0) == '0' && blockedSide != 0) {
			if (row > 0) {
				// pathArray = new ArrayList<>(pathTraverse(row - 1, column, 2, pathArray,str));
				 val = pathTraverse(row - 1, column, 2, pathArray,str,pathArrayrerult);
			}else{
				pathArrayrerult.add(str);
			}
		}
		if (dogMaze[row][column].charAt(1) == '0' && blockedSide != 1) {

			if (column > 0) {
				// pathArray = new ArrayList<>( pathTraverse(row, column - 1, 3,  pathArray,str));
				 val = pathTraverse(row, column - 1, 3,  pathArray,str,pathArrayrerult);
			}else{
				
				pathArrayrerult.add(str);
				

			}
		}
		if (dogMaze[row][column].charAt(2) == '0' && blockedSide != 2) {
			if (row < dogMaze.length - 1) {
				// pathArray = new ArrayList<>(pathTraverse(row + 1, column, 0,pathArray,str));
				 val = pathTraverse(row + 1, column, 0,pathArray,str,pathArrayrerult);
			}else{
				
				pathArrayrerult.add(str);
				
			}

		}
		if (dogMaze[row][column].charAt(3) == '0' && blockedSide != 3) {
			if (column < dogMaze[0].length - 1) {
				// pathArray = new ArrayList<>(pathTraverse(row, column + 1, 1, pathArray,str));
				 val = pathTraverse(row, column + 1, 1, pathArray,str,pathArrayrerult);
			}else{
				
				pathArrayrerult.add(str);
				
			}
		}
		return val;
	}
	public static void main(String [] args){
		findPath(1,0);
	}




}


/**
 * This class defines a <code> maze </code> using a 2D array. 
 * To complete the code, you should not change the method 
 * signatures (header). 
 *
 */

class Maze{
	private String [][] maze;

	/**
	 * This constructor makes the maze. 
	 * @param maze is a 2D array that contains information 
	 * on how each cell of the array looks like.
	 */
	public Maze(String[][] maze) {

		this.maze = maze;
		for (int i = 0; i< maze.length; i++){
			for (int j = 0; j< maze[0].length; j++){
				this.maze[i][j] =  maze[i][j];
			}
		}

		/*complete the constructor so that the maze is 
		 * a deep copy of the input parameter. 
		 */
	}

	/**
	 * This accessor (getter) method returns a 2D array that
	 * represents the maze
	 * @return it returns a reference to the maze
	 */
	public String[][] getMaze(){

		/* complete this method providing that a clone of 
		 * the maze should be returned. 
		 * you may want to change the return value to fit your purpose.
		 */
		String [][] mazeCopy = new String[this.maze.length][this.maze[0].length];
		for (int i = 0; i< this.maze.length; i++){
			for (int j = 0; j< this.maze[0].length; j++){
				mazeCopy[i][j] = this.maze[i][j];
			}
		}
		return mazeCopy;
	}
	
	@Override 
	public String toString() {
		if((getMaze().length & getMaze()[0].length) == 0){
			return "Empty Maze";
		}
		String maze_toString = "";
		for (int i = 0; i< getMaze().length; i++) {
			maze_toString += "[";
			for(int j = 0; j< getMaze()[i].length; j++) {
				maze_toString += getMaze()[i][j]+ " ";
			}
			maze_toString = maze_toString.trim();
			maze_toString += "]";
			maze_toString +="\n";
		}
		//insert your code here. Change the return value to fit your purpose.
		return maze_toString;
	}


	
}// end of class Maze
