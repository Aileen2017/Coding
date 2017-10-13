/**
 * 
 */


public class SudokoPuzzleMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] puzzle = new int [] {
				0,0,2,5,0,0,0,0,3,
				0,4,0,0,6,7,0,0,0,
				1,5,0,0,0,3,0,0,0,
				0,0,8,0,0,0,0,0,4,
				5,6,0,0,0,0,0,1,7,
				4,0,0,0,0,0,8,0,0,
				0,0,0,6,0,0,0,8,1,
				0,0,0,1,8,0,0,2,0,
				2,0,0,0,0,5,7,0,0 };
		printPuzzle(puzzle);
	}
	
	
	public static void printPuzzle(int[] numbers){
		int rowcount = 0;
		for(int i=0; i< numbers.length; i++){
			
			int mod = i%9;
			if(mod == 0 && rowcount%3 ==0 && rowcount < 9&&rowcount>0){
				System.out.println("---+---+---");
			}
			if(mod <2){
				printNumber(numbers[i]);
			}
			else if (mod == 2){
				printNumber(numbers[i]);
				System.out.print("|");
				
			}
			else if(mod>2 && mod<5){
				printNumber(numbers[i]);
			}
			else if(mod == 5){
				printNumber(numbers[i]);
				System.out.print("|");
			}
			else if(mod>5 && mod<8){
				printNumber(numbers[i]);
			}
			else if(mod == 8){
				printNumber(numbers[i]);
				System.out.println();
				rowcount++;
			}
		
		}

	}
	
	public static boolean isPositionValid(int location, int num){
		int[] puzzle = new int [] {
				0,0,2,5,0,0,0,0,3,
				0,4,0,0,6,7,0,0,0,
				1,5,0,0,0,3,0,0,0,
				0,0,8,0,0,0,0,0,4,
				5,6,0,0,0,0,0,1,7,
				4,0,0,0,0,0,8,0,0,
				0,0,0,6,0,0,0,8,1,
				0,0,0,1,8,0,0,2,0,
				2,0,0,0,0,5,7,0,0 };
		
		boolean valid = true;
		int row = location/9;
		int col = location%9;
		int rowLowerLimit = location - col;
		int rowUpperLimit = location + (8-col);
		for(int i = rowLowerLimit; i< (rowUpperLimit+1); i++){
			if(puzzle[i] == num){
				valid = false;
				return valid;
			}
		}
		int colLowerLimit = location - 9* row;
		int colUpperLimit = location + 9*(8-row);
		for(int i = colLowerLimit; i<= colUpperLimit; i= i+9){
			if(puzzle[i]==num){
				valid = false;
				return valid;
			}
		}
		
		return valid;
		
	}
	
	public static void printNumber(int num){
		if(num == 0)
			System.out.print(" ");
		else
			System.out.print(num);
	}

}
