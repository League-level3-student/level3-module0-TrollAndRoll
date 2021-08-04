package _00_Intro_To_Arrays;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class _02_RobotRace {
	// 1. make a main method
	public static void main(String[] args) {
		// 2. create an array of 5 robots.
		Robot[] robotArray = new Robot[5];
		Integer[] distTracker = new Integer[robotArray.length];
		Robot.setWindowSize(500, 400);
		// 3. use a for loop to initialize the robots.
		// 4. make each robot start at the bottom of the screen, side by side, facing up
		int xPos = 300;
		for (int i = 0; i < robotArray.length; i++) {
			robotArray[i] = new Robot();
			robotArray[i].setX(xPos);
			robotArray[i].setY(300);
			robotArray[i].setSpeed(500);
			robotArray[i].setRandomPenColor();
			robotArray[i].penDown();
			distTracker[i] = 0;
			//xPos += 100;
		}
		// 5. use another for loop to iterate through the array and make each robot move
		// a random amount less than 50.
//		for (i = 0; i < robotArray.length; i++) {
//			robotArray[i].setY(robotArray[i].getY() - rand.nextInt(51));
//		}
		// 6. use a while loop to repeat step 5 until a robot has reached the top of the
		// screen.
//		Random rand = new Random();
//		int i = 0;
//		while(robotArray[i].getY() > 0) {
//			robotArray[i].setY(robotArray[i].getY() - rand.nextInt(51));
//			i++;
//			if(i > robotArray.length-1) i = 0;
//		}
//		// 7. declare that robot the winner and throw it a party!
//		System.out.println("Robot #" + (i+1) + " is the winner! Let's party!!");
		// 8. try different races with different amounts of robots.
		// Check!
		// 9. make the robots race around a circular track.
		Random rand = new Random();
		int i = 0, j = 0;
		int dist = 1;
		//Integer tempt;
		while (j < 72) {//72
//			while ((dist % 2) != 0) {
//				
//			}
			dist = rand.nextInt(51);
//			distTracker[i] = distTracker[i] + dist;
			for(int x = 0; x < dist; x++) {
				robotArray[i].move(1);
				distTracker[i] = distTracker[i] + 1;
				if(distTracker[i] >= 20) {
					robotArray[i].turn(10);
					distTracker[i] = distTracker[i] - 20;
				}
			}
			//robotArray[i].move(dist);
//			tempt = distTracker[i];
//			distTracker[i] = tempt + dist;
//			if (distTracker[i] >= 20) {
//				robotArray[i].turn(10);
//				distTracker[i] = distTracker[i] - 20;
//			}
			i++; j++;
			if (i > robotArray.length - 1) {
				i = 0;
			}
		}
		System.out.println("Robot #" + (i + 1) + " is the winner! Let's party!!");
	}
}
