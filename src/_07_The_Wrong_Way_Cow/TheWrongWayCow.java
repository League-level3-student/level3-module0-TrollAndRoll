/*
 * https://www.codewars.com/kata/the-wrong-way-cow
 * 
 * Task
 * Given a field of cows find which one is the Wrong-Way Cow and return her
 * position.
 * 
 * Notes:
 * 
 * There are always at least 3 cows in a herd
 * There is only 1 Wrong-Way Cow!
 * Fields are rectangular
 * The cow position is zero-based [col,row] of her head (i.e. the letter c)
 * Examples
 * Ex1
 * 
 * cow.cow.cow.cow.cow
 * cow.cow.cow.cow.cow
 * cow.woc.cow.cow.cow
 * cow.cow.cow.cow.cow
 * Answer: [6,2]
 * 
 * Ex2
 * 
 * c..........
 * o...c......
 * w...o.c....
 * ....w.o....
 * ......w.cow
 * Answer: [8,4]
 * 
 * Notes
 * The test cases will NOT test any situations where there are "imaginary" cows,
 * so your solution does not need to worry about such things!
 * 
 * To explain - Yes, I recognize that there are certain configurations where an
 * "imaginary" cow may appear that in fact is just made of three other "real" cows.
 * 
 * In the following field you can see there are 4 real cows (3 are facing south and
 * 1 is facing north). There are also 2 imaginary cows (facing east and west).
 * 
 * ...w...
 * ..cow..
 * .woco..
 * .ow.c..
 * .c.....
*/

package _07_The_Wrong_Way_Cow;

public class TheWrongWayCow {
	
	static int NCows, ECows, SCows, WCows;
	
	public static int[] findWrongWayCow(final char[][] field) {
		// Fill in the code to return the [col, row] coordinate position of the
		// head (letter 'c') of the wrong way cow!
		int cellsPerRow = field[0].length;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == 'c') {
					int cowType = checkForCow(field, cellsPerRow, i, j);
					
					if(cowType == 1) {
						NCows++;
					}
					else if(cowType == 2) {
						ECows++;
					}
					else if(cowType == 3) {
						SCows++;
					}
					else if (cowType == 4) {
						WCows++;
					}
					
				}
			}
		}
		
		int[] cowTypes = new int[4];
		cowTypes[0] = NCows;
		cowTypes[1] = ECows;
		cowTypes[2] = SCows;
		cowTypes[3] = WCows;
		
		int max = cowTypes[0];
		
		int correctCow = findCorrectCow(cowTypes, max);
		
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == 'c') {
					int cowType = checkForCow(field, cellsPerRow, i, j);
					
					if(cowType != correctCow) {
						int[] wrongWayCow = new int[]{i, j};
						return wrongWayCow;
					}
				}
			}
		}
		
		return null;
	}
	
	public static int findCorrectCow(int[] array, int maxValue) {//find the cow type that occured most often (that is correct cow)
		for (int i = 1; i < array.length; i++) {
			if(array[i] > maxValue) {
				maxValue = array[i];
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			if(array[i] == maxValue) {
				return i;
			}
		}
		return -1;
	}
	
	public static int checkForCow(char[][] field, int cellsPerRow, int cellRow, int cellCol) {
		if (cellRow < cellsPerRow - 2) {//if not at the end of the row (that a cow can fit)
			if (field[cellRow + 1][cellCol] == 'o' && field[cellRow + 2][cellCol] == 'w') {//then check to the right for cow
				return 1;//East
			}
		}
		if (cellRow > 1) {//if there is enough room left for cow
			if (field[cellRow - 1][cellCol] == 'o' && field[cellRow - 2][cellCol] == 'w') {//then check to the left for cow
				return 2;//West
			}
		}
		if (cellCol > 1) {//if there is enough room up for cow
			if (field[cellRow + 1][cellCol] == 'o' && field[cellRow + 2][cellCol] == 'w')
				return 3;//North
		}
		if (cellCol < cellsPerRow - 2) {//if cow can fit down
			if (field[cellRow][cellCol + 1] == 'o' && field[cellRow][cellCol + 2] == 'w')//check down for cow
				return 4;//South
		}
		return -1;
	}
	
	/*public static int checkFortest(char[][] field, int cellsPerRow, int cellRow, int cellCol) {
		if (cellRow != cellsPerRow - 1) {//North #1 (east?)
			if (field[cellRow + 1][cellCol] == 'o' && field[cellRow + 2][cellCol] == 'w')
				return 1;
		}
		if (cellRow != 0 && cellCol != 0) {//East #2 (south?)
			if (field[cellRow][cellCol - 1] == 'o' && field[cellRow][cellCol - 2] == 'w')
				return 2;
		}
		if (cellRow != 0 && cellCol != cellsPerRow - 1) {//South #3 (north?)
			if (field[cellRow][cellCol + 1] == 'o' && field[cellRow][cellCol + 2] == 'w')
				return 3;
		}
		if (cellCol != cellsPerRow - 1) {//West #4
			if (field[cellRow - 1][cellCol] == 'o' && field[cellRow - 2][cellCol] == 'w')
				return 4;
		}
		return 0;
	}

	public static boolean checkForW(char[][] field, int cellsPerRow, int cellRow, int cellCol, int direction) {
		if (cellRow != cellsPerRow - 1 && direction == 1) {
			if (field[cellRow + 1][cellCol] == 'w')
				return true;
		}
		else if (direction == 2 && cellRow != 0 && cellCol != 0) {
			if (field[cellRow - 1][cellCol - 1] == 'w')
				return true;
		}
		else if (direction == 3 && cellRow != 0 && cellCol != cellsPerRow - 1) {
			if (field[cellRow - 1][cellCol + 1] == 'w')
				return true;
		}
		else if (cellCol != cellsPerRow - 1) {
			if (field[cellRow][cellCol + 1] == 'w')
				return true;
		}
		return false;
	}*/
}
