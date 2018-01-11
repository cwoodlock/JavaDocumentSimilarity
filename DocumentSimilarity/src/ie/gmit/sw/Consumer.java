package ie.gmit.sw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/*
 * Colm Woodlock
 * G00341460
 * Object Oriented Programming Main Assignment
 */

public class Consumer implements Runnable{
	
	//Variables
	private BlockingQueue<Shingle> q;
	private int k;
	private int [] hashes;	//the random stuff
	private Map<Integer, List<Integer>> map = new HashMap<>();
	
	public Consumer(BlockingQueue<Shingle> q, int k, int poolSize) {
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
