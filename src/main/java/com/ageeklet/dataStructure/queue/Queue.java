package com.ageeklet.dataStructure.queue;

public class Queue {
	private int maxSize;
	private long[] queueArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue(int s) {
		this.maxSize = s;
		queueArray = new long[s];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	/*
	 * insert()方法运行的前提是队列不满
	 * 一般情况下，插入操作是rear（队尾指针）+1后，在队尾指针所指的位置插入新的数据。但是，当rear指针指向数组的顶端，
	 * 既maxSize-1位置的时候，在插入数据项之前，它必须回绕到数组的低端。回绕操作把rear设置为-1，因此当rear+1后，它等于0，
	 * 是数组低端的下标值。最后，nItems+1；
	 */
	public void insert(long j) {
		if(rear == maxSize - 1) {
			rear = -1;
		}
		queueArray[++rear] = j;
		nItems ++;
	}
	
	/*
	 * remove()方法前提是队列不为空
	 * 移除操作总是由front指针得到队头数据项的值，然后将front+1。但是，如果这样做使front的值超过数组的顶端，
	 * front就必须绕回到数组下标为0的位置上。作这种检验的同时，现将返回值临时存起来。最后nItems-1。
	 */
	public long remove() {
		long temp = queueArray[front++];
		if(front == maxSize) {
			front = 0;
		}
		nItems --;
		return temp;
	}
	
	/*
	 * 返回front指针所指数据项的值。
	 */
	public long peekFront() {
		return queueArray[front];
	}
	
	public boolean isEmpty() {
		return (nItems==0);
	}
	
	public boolean isFull() {
		return (nItems==maxSize);
	}
	
	public int size() {
		return nItems;
	}
}









