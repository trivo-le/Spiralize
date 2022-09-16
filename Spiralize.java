import java.util.Scanner;

public class Spiralize {

	static int distance = 1, elementVal = 1, lastRow, lastCol;
	
	public static void main(String[] args) {
		
	//Get the size of the matrix	
	int size = getTwoDSize();
	
	//An array, size must be an square with an odd number of rows and columns
	int[][]matrix = new int[size][size];
	
	//Prints the spiral array
	
		Printing.printTwoD(spiralize(matrix));
	
	}//main
	public static int getTwoDSize () {
	//Returns the size of the matrix taken from the user
		
	Scanner input = new Scanner(System.in);
		
	int sidelength;
	
	do {
		
		System.out.println("What is the sidelength of the square matrix?");
		sidelength = input.nextInt();
		
		//Filter out negative numbers
		if (sidelength<=0) {
			System.out.println("Invalid size, please input a number greater than 0");	
			}//if
		} while (sidelength<=0);
		
	input.close();
	return sidelength;
	}
	public static int[][] spiralize (int[][]twoD) {
	//Returns an array that is filled starting from its center element in a spiral pattern
		
		String parity = "even";
		
		//If a 1x1 array, return 1
		if (twoD.length==1) {
			twoD[0][0]=1;
			return twoD;
			}
		
		
		else if (checkParity(twoD)=="odd"){
			//Start at the middle row and column
			lastRow = (twoD.length-1)/2;
			lastCol = (twoD[0].length-1)/2;
			parity = "odd";
			}//else if
		
		else {
			//Start one element below the "center" 
			lastRow = (twoD.length)/2;
			lastCol = (twoD[0].length-1)/2;
			}
			
		//While the bottom right and top left corner are equal to 0, then continue to fill the array
		while (twoD[twoD.length-1][twoD[0].length-1]==0 && twoD[0][0]==0) {
			
			//Move right and up by the distance, then increase distance of movement by one
			twoD = right(distance,twoD,lastRow,lastCol);
			twoD = up(distance,twoD,lastRow,lastCol);
			
			//For even matrices: If on the top row, then move right and the spiral is finished.
			if (parity=="even" && lastRow == 0) {
				twoD = left(distance,twoD,lastRow,lastCol);
				break;
				}//if
			
			distance++;
		
			//Move left and down by the distance
			twoD = left(distance,twoD,lastRow,lastCol);
			twoD = down(distance,twoD,lastRow,lastCol);
		
			//For odd matrices: If on the bottom row, then move right and the spiral is finished.
			if (parity=="odd" && lastRow==twoD.length-1) {
				twoD = right(distance,twoD,lastRow,lastCol);
				break;
				}//if
			
			distance++;
			}//while
		
			return twoD;
	}
	public static String checkParity (int[][]twoD) {
	// Returns a string describing the parity of the square matrix passed to its parameters based on the matrix' number of rows	
		
		//If odd, then return odd
		if (twoD.length%2!= 0) {
			return "odd";
			}
		
		else { 
			return "even"; 
			}
		
		}//checkParity
	public static int[][] right (int distance, int[][]twoD, int lRow, int lCol) {
	/* Returns a given array passed to its parameters which is filled in the right direction 
	 * by a certain number of elements based on the distance, as well as which element to start filling 
	 * at based on the last row and column passed to the parameters */
		
		//Gets the column from the last element, then assigns values to the right depending on the distance
		for (int col = lCol; col <= (lCol+distance); col++) {
			twoD[lRow][col] = elementVal;
			elementVal++;
			
			//The last filled column becomes the column that was last filled
			lastCol = col;
			}//for
		
		elementVal--;
		return twoD;	
		}//right
	public static int[][] up (int distance, int[][]twoD, int lRow, int lCol) {
	/* Fills a given array passed to its parameters in the upwards direction by a certain number of elements 
	 * based on the distance, as well as which element to start filling at based on the 
	 * last row and column passed to the parameters*/
		
		for (int row = lRow; row >= (lRow-distance); row--) {
			
			twoD[row][lCol] = elementVal;
			elementVal++;
			
			//Row updates
			lastRow = row;
			}//for
		
		elementVal--;
		return twoD;	
		}//up
	
	public static int[][] left (int distance, int[][]twoD, int lRow, int lCol) {
	/* Returns a given array passed to its parameters which is filled in the left direction 
	 * by a certain number of elements based on the distance, as well as which element to start filling 
	 * at based on the last row and column passed to the parameters */	
		
		for (int col = lCol; col >= (lCol-distance); col--) {
			twoD[lRow][col] = elementVal;
			elementVal++;
			
			lastCol = col;
			}//for
		
		elementVal--;
		
		return twoD;	
		}//left
	
	public static int[][] down (int distance, int[][]twoD, int lRow, int lCol) {
	/* Fills a given array passed to its parameters in the downwards direction by a certain number of elements 
	 * based on the distance, as well as which element to start filling at based on the 
	 * last row and column passed to the parameters*/	
		
		for (int row = lRow; row <= (lRow+distance); row++) {

			twoD[row][lCol] = elementVal;
			elementVal++;
		
			lastRow = row;
			}//for
		
		elementVal--;
		return twoD;	
		}//up
	
}
