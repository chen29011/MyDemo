package com.cqlj.cataTools.patternsInJava.build;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Product {
	List<String> list = new ArrayList<String>();

	public void add(String str) {
		list.add(str);
	}

	public void show() {
		Iterator<String> i = list.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
