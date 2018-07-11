package com.ageeklet.dataStructure.link.sortedLink;

import com.ageeklet.dataStructure.link.Link;

public class SortedList2 {
	private Link first;
	
	public SortedList2() {
		first = null;
	}
	
	public SortedList2(Link[] linkArr ) {
		first = null;
		for (int i = 0; i < linkArr.length; i++) {
			insert(linkArr[i]);
		}
	}
	
	public boolean isEmpty() {
		return (first==null);
	}
	
	public void insert(Link k) {
		Link previous = null;
		Link current = first;
		
		while(current!=null && k.dData>current.dData) {
			previous = current;
			current = current.next;
		}
		if(previous==null) {
			first = k;
		}else {
			previous.next = k;
		}
		k.next = current;
	}
	
	public Link remove() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.print("List(first-->last):");
		Link current = first;
		while(current!=null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}
