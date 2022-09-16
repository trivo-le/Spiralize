
public class Printing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void printTwoD (int[][]twoD) {
		//PRINTS A TWO DIMENSIONAL ARRAY PASSED TO THE PARAMETERS
			
		for (int row = 0; row < twoD.length; row++) {
			
			for (int col = 0; col < twoD[row].length; col++ ) {
					
				System.out.print(twoD[row][col] + "\t");
				
				}//for
			
			System.out.println("\n");
			
			}//for
			
		}//print2D
	
}
