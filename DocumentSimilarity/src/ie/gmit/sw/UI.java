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
	private String file1,file2;
	private int shingle;
	private int blockingQueue;
	
	//Constructors
	public UI() {
		super();
	}
	
	//Methods
	public void mainMenu() {
		
		//Prompt user to enter choice
		System.out.println("Main menu \nPlease enter 1 to compare Documents \nPlease enter 2 to exit");
		choice = sc.nextInt();
		
		//Call method depending on user input
		if(choice == 1) {
			compareDocuments();
			
		} else if (choice == 2) {
			
		} else if(choice < 1 || choice > 2) {
			
		}
		
	}
	
	public void compareDocuments() {
		
		//Prompt user to enter file names
		System.out.println("Please enter the name of the first file: ");
		file1 = sc.next();
		
		System.out.println("Please enter the name of the second file: ");
		file2 = sc.next();
		
		//Prompt user for the size of the shingle
		System.out.println("Please enter the size of the shingle: ");
		shingle = sc.nextInt();
		
		//Prompt user for the size of the blocking queue
		System.out.println("Please enter the size of the blocking queue: ");
		blockingQueue = sc.nextInt();
		
		//Create Launcher and call Launch
		Launcher l = new Launcher();
		l.Launch(file1, file2, shingle, blockingQueue);
		
	}

}
