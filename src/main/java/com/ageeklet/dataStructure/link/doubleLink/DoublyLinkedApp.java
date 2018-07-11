package com.ageeklet.dataStructure.link.doubleLink;

public class DoublyLinkedApp {
	public static void main(String[] args) {
		DoubleLinkedList theList = new DoubleLinkedList();
		
		theList.insertFirst(22);
		theList.insertFirst(44);
		theList.insertFirst(66);
		
		theList.insertLast(11);
		theList.insertLast(33);
		theList.insertLast(55);
		
		theList.dispalyForward();
		theList.displayBackword();
		
		theList.deleteFirst();
		theList.deleteLast();
		theList.deleteKey(11);
		
		theList.dispalyForward();
		
		theList.insertAfter(22, 77);
		theList.insertAfter(33, 88);
		
		theList.dispalyForward();
	}
}
