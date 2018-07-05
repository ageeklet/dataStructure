package com.ageeklet.dataStructure.priorityQueue;

public class PriorityQueue {
	private int maxSize;
	private long[] queueArray;
	private int nItems;
	
	public PriorityQueue(int s) {
		this.maxSize = s;
		queueArray = new long[s];
		nItems = 0;
	}
	
	/*
	 * insert方法先检查队列中是否有数据项；如果没有，就插入到下标为0的单元里。
	 * 否则，从数组顶部开始上移存在的数据项，直到找到新数据项应当插入的位置。
	 * 然后，插入新数据项，并把nItems+1。
	 * 注意优先级队列可能出现满的情况，应当在用insert()方法之前调用isFull()判断这种可能性。
	 */
	public void insert(long item) {
		int j ;
		if (nItems == 0) {
			queueArray[nItems++] = item;
		}else {
			for(j=nItems-1;j>=0;j--) {
				if(item > queueArray[j]) {
					queueArray[j+1] = queueArray[j];
				}else {
					break;
				}
			}
			queueArray[j+1] = item;
			nItems ++;
		}
	}
	
	/*
	 * 把nItems减一并返回数组顶部的数据项
	 */
	public long remove() {
		return queueArray[--nItems];
	}
	
	public long peekMin() {
		return queueArray[nItems-1];
	}
	
	public boolean isEmpty() {
		return (nItems==0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
}

