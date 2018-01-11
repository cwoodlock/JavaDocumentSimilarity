package ie.gmit.sw;

/*
 * Colm Woodlock
 * G00341460
 * Object Oriented Programming Main Assignment
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Launcher {
	//k in this case is the size of the minHash
	public void Launch(String file1, String file2, int shingleSize, int k, int blockingQueue) {
		//Create blocking queue
		BlockingQueue<Shingle> q = new LinkedBlockingQueue<>(k);
		
		//Threads
		Thread t1 = new Thread(new DocumentParser(file1, q, shingleSize, 1), "T1");
		Thread t2 = new Thread(new DocumentParser(file2, q, shingleSize, 2), "T2");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
		
}
