package ie.gmit.sw;

/*
 * Colm Woodlock
 * G00341460
 * Object Oriented Programming Main Assignment
 */

import java.util.Scanner;

public class UI {
	
	//variables
	private int choice = 0;
	private Scanner sc = new Scanner(System.in);
	
	//Constructors
	public UI() {
		
	}
	
	//Methods
	public void mainMenu() {
		
		//Prompt user to enter choice
		System.out.println("Main menu \nPlease enter 1 to compare Documents \nPlease enter 2 to exit");
		choice = sc.nextInt();
		
		
	}

}
