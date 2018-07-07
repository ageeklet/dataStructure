package com.ageeklet.dataStructure.link.doubleSideChainTable;

public class FirsrLastList {
	private Link first;
	private Link last;
	
	public FirsrLastList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first==null;
	}

	/*
	 * 在表头重复插入会颠倒链结点进入的顺序
	 */
	public void insertFirst(long d) {
		Link newLink = new Link(d);
		/*
		 * 若插入前链表是空的，若isEmpty()为真，
		 * 那么insertFirst()必须把last指向新的链结点
		 */
		if(isEmpty()) {
			last = newLink;
		}
		newLink.next = first;
		first = newLink;
	}
	
	/*
	 * 在表尾重复插入则保持连接点的进入的顺序
	 * 这个方法在表尾插入一个新的链结点。
	 * 首先改变last.next,使其指向新生成的链结点，然后改变last，使其指向新的链结点
	 */
	public void insertLast(long d) {
		Link newLink = new Link(d);
		/*
		 * 若插入前链表是空的，若isEmpty()为真，
		 * 那么insertLast()必须把first指向新的链结点
		 */
		if(isEmpty()) {//first==null
			first = newLink;
		}else {
			last.next = newLink;
		}
		last = newLink;
	}
	
	public long deleteFirst() {
		long temp = first.dData;
		if(first.next==null) {
			last = null;
		}
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

