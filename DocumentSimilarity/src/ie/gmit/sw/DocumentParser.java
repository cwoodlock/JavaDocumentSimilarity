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
	private int shingleSize, k;
	private BufferedReader br = null;
	private Deque<String> buffer = new LinkedList<>();
	
	//Constructor
	public DocumentParser(String file, BlockingQueue<Shingle> q, int shingleSize, int k) {
		this.q = q;
		this.file = file;
		this.shingleSize = shingleSize;
		this.k = k;
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
			}
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

	private void addWordsToBuffer(String[] words) {
		
		for(String s: words) {
			buffer.add(s);
		}
		
	}
	
}
