package ie.gmit.sw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Colm Woodlock
 * G00341460
 * Object Oriented Programming Main Assignment
 */

public class Consumer implements Runnable{
	
	//Variables
	private BlockingQueue<Shingle> q;
	private int k;	
	private int [] minhashes;	//the random stuff
	private Map<Integer, List<Integer>> map = new HashMap<>();
	private ExecutorService pool;
	
	public Consumer(BlockingQueue<Shingle> q, int k, int poolSize) {
		
		this.q = q;
		this.k =k;
		pool = Executors.newFixedThreadPool(poolSize);
		init();
		
	}

	private void init() {
		
		Random random = new Random();
		minhashes = new int[k]; //200-300
		for(int i =0; i < minhashes.length; i++) {
			minhashes[i] = random.nextInt();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
