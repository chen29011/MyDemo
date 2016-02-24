package com.cqlj.cataTools.queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Test1 implements Runnable {
	private final List<String> queue;
	Test1(List q) {  
	    queue = q;  
	  }  

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 999999; i++) {
			queue.add(i+"");
			//System.out.println("添加值"+i);
		}
	}
}

class Test2 implements Runnable {

	private final List<String> queue;
	Test2(List q) {  
	    queue = q;  
	  }  

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 999999; i++) {
			queue.remove(0);
			System.out.println("去除值"+i);
		}
	}

}

public class TestQueue {
	
	public static void main(String[] args) {
		List ll =  Collections.synchronizedList(new LinkedList());
		//List ll =  new LinkedList();
		Test1 t1 = new Test1(ll);
		
		new Thread(t1).start();
		
		Test2 t2 = new Test2(ll);
		new Thread(t2).start();
	}
}
