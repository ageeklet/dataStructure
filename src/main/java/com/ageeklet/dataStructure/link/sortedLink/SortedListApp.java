package com.ageeklet.dataStructure.link.sortedLink;

import com.ageeklet.dataStructure.link.Link;

public class SortedListApp {
	public static void main(String[] args) {
		int size = 10;
		Link[] linkArr = new Link[size];
		for (int i = 0; i < size; i++) {
			int n = (int)(Math.random()*99);
			Link newLink = new Link((long) n);
			linkArr[i] = newLink;
 		}
		System.out.print("Unsorted array:");
		for (int i = 0; i < linkArr.length; i++) {
			System.out.print(linkArr[i].dData+" ");
		}
		System.out.println(" ");
		
		SortedList2 theList = new SortedList2(linkArr);
		
		for (int i = 0; i < linkArr.length; i++) {
			linkArr[i] = theList.remove();
		}
		System.out.print("Sorted Array:");
		for (int i = 0; i < linkArr.length; i++) {
			System.out.print(linkArr[i].dData+" ");
		}
		System.out.println("");
	}
	
	public static void main2(String[] args) {
		SortedList theList = new SortedList();
		theList.insert(20);
		theList.insert(40);
		
		theList.displayList();
		
		theList.insert(10);
		theList.insert(30);
		theList.insert(50);
		
		theList.displayList();
		
		theList.remove();
		
		theList.displayList();
	}
}
