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
	private int threadPoolSize;
	private int k;
	
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
			return;
		} else if(choice < 1 || choice > 2) {
			System.out.println("Please enter 1 or 2");
			choice = sc.nextInt();
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
		
		//Prompt user for the size of the minhash
		System.out.println("Please enter the size of the minHash: ");
		k = sc.nextInt();
		
		//Prompt user for the size of the thread pool
		System.out.println("Please enter the size of the thread pool: ");
		threadPoolSize = sc.nextInt();
		
		//Create Launcher and call Launch
		Launcher l = new Launcher();
		l.Launch(file1, file2, shingle, k, threadPoolSize);
		
	}

}
