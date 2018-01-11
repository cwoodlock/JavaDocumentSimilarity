package ie.gmit.sw;

/*
 * Colm Woodlock
 * G00341460
 * Object Oriented Programming Main Assignment
 */

import java.util.concurrent.BlockingQueue;

public class DocumentParser implements Runnable{

	//Variables
	private String file;
	private BlockingQueue<Shingle>q;
	private int shingleSize, k;
	
	public DocumentParser(String file, BlockingQueue<Shingle> q, int shingleSize, int k) {
		this.q = q;
		this.file = file;
		this.shingleSize = shingleSize;
		this.k = k;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
