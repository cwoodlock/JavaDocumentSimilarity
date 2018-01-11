package ie.gmit.sw;

/*
 * Colm Woodlock
 * G00341460
 * Object Oriented Programming Main Assignment
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Launcher {
	//k in this case is the size of the blocking queue
	public void Launch(String file1, String file2, int shingleSize, int k) {
		//Create blocking queue
		BlockingQueue<Shingle> q = new LinkedBlockingQueue<>(k);
		
		//Threads
		Thread t1 = new Thread(new DocumentParser(file1, q, shingleSize, k), "T1");
		Thread t2 = new Thread(new DocumentParser(file2, q, shingleSize, k), "T2");
		
	}
		
}
