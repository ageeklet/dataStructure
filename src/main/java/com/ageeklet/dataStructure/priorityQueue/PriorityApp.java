package com.ageeklet.dataStructure.priorityQueue;

public class PriorityApp {
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue(5);
		pq.insert(30);
		pq.insert(50);
		pq.insert(10);
		pq.insert(40);
		pq.insert(20);
		
		while(!pq.isEmpty()) {
			long item = pq.remove();
			System.out.print(item+" ");
		}
		System.out.println("");
	}
}
