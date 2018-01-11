package ie.gmit.sw;

/*
 * Colm Woodlock
 * G00341460
 * Object Oriented Programming Main Assignment
 */

import java.util.concurrent.BlockingQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;


public class DocumentParser implements Runnable{

	//Variables
	private String file;
	private BlockingQueue<Shingle>q;
	private int shingleSize, docID;
	private BufferedReader br = null;
	private Deque<String> buffer = new LinkedList<>();
	
	//Constructor
	public DocumentParser(String file, BlockingQueue<Shingle> q, int shingleSize, int docID) {
		this.q = q;
		this.file = file;
		this.shingleSize = shingleSize;
		this.docID = docID;
	}

	@Override
	public void run() {
		//Try catches auto-generated, was giving errors otherwise
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String line = null;
		
		try {
			while((line = br.readLine()) != null) {
				
				String uLine = line.toUpperCase();
				String [] words = uLine.split("\\s+"); //Adapted from https://stackoverflow.com/questions/225337/how-do-i-split-a-string-with-any-whitespace-chars-as-delimiters
				addWordsToBuffer(words);
				
				Shingle s = getNextShingle();
				q.put(s);
			}
			
			flushBuffer();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void flushBuffer() {
		
		while(buffer.size() > 0) {
			Shingle s = getNextShingle();
			
			if(s != null) {
				try {
					q.put(s);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				q.put(new Poison(docID, 0));
			}
		}
		
	}

	private Shingle getNextShingle() {
		
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		
		while(counter < shingleSize) {
			if(buffer.peek() != null) {
				sb.append(buffer.poll());
			}
			counter++;
		}
		if(sb.length() < 0) {
			return null;
		} else {
			return (new Shingle(docID, sb.toString().hashCode()));
		}
	}

	private void addWordsToBuffer(String[] words) {
		
		for(String s: words) {
			buffer.add(s);
		}
		
	}
	
}
