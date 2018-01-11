package ie.gmit.sw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
	
	//Customer object to run on T3
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
		
		int docCount = 2;
		
		while(docCount > 0) {
			try {
				
				Shingle s = q.take();	//Blocking method
				
				if(s instanceof Poison) {
					docCount--;
					
				} else {
					
					pool.execute(new Runnable() {

						@Override
						public void run() {
							
							for(int i = 0; i < minhashes.length; i++) {
								int value = s.getHashcode()^minhashes[i];
								List<Integer> list = map.get(s.getDocId());
								
								if(list == null) {
									list = new ArrayList<Integer>(k);
									
									for(int j = 0; j < list.size(); j++) {
										list.set(j, Integer.MAX_VALUE);
									}
									map.put(s.getDocId(), list);
								} else {
									
									if(list.get(i) > value) {
										list.set(i, value);
									}
									
								}
							}
						}
						
					});
					
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//Adapted from https://www.callicoder.com/java-executor-service-and-thread-pool-tutorial/
		pool.shutdown();
		try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            throw new IllegalStateException(ex);
        }
		
		List<Integer> intersection = new ArrayList();
		intersection.retainAll(b);
		
		float jaccard = (float)intersection.size()/(k*2-(float)intersection.size());
		
		//Display result
		System.out.println("File 1 and File 2 have a " + (jaccard) * 100 + "% similarity.");
		/*
		 *This does not work when trying to find the intersection of the  hash values stored on the map
		 */
	}

}
