package com.ageeklet.dataStructure.link.singleLinkedList;

public class LinkList {

	//链表中第一个链结点的引用，是唯一的链表需要维护的永久信息,用以定位其他所有的链结点
	private Link first;
	
	public void LinkList() {
		this.first = null;
	}
	
	public boolean isEmpty() {
		return 	(first==null);
	}
	
	/*
	 * 在表头插入一个新链结点。以为first已经指向了第一个链结点，为了插入新的链结点，
	 * 只需要使新创建的链结点的next字段等于原来的first值，然后改变first的值，使它
	 * 指向新创建的链结点
	 */
	public void insertFirst(int id,double dd) {
		Link newLink = new Link(id, dd);
		newLink.next = first;
		first = newLink;
	}
	
	/*
	 * current开始时指向first，然后通过不断的把自己赋值为current.next,沿着链表向前移动
	 * 在每个链结点处，find()检查链结点的关键值是否与他寻找的相等。如果找到了，它返回对该
	 * 链结点的引用。如果find()到达链表尾端，但没有发现要找的链结点，则返回null
	 */
	public Link find(int key) {
		Link current = first;
		while(current.iData!=key) {
			if(current.next==null) {
				return null;
			}else {
				current = current.next;
			}
		}
		return current;
	}
	
	/*
	 * 先搜索要删除的链结点。然而它需要掌握的不仅是指向当前的链结点（current）的引用，
	 * 还有指向当前链结点的前一个（previous）链结点的引用。
	 * 如果要删除当前的链结点，必须把前一个链结点和后一个链结点连在一起
	 */
	public Link delete(int key) {
		Link current = first;
		Link previous = first;
		while(current.iData!=key) {
			if(current.next==null) {
				return null;
			}else {
				previous = current;
				current = current.next;
			}
		}
		if(current == first) {
			first = first.next;
		}else {
			previous.next = current.next;
		}
		return current;
	}
	/*
	 * 通过把first重新指向第二个链结点，断开了和第一个链结点的连接
	 * first = first.next; 是从链表中删除一个链结点。最后需要返回一个链结点，为了链表的使用者的方便，
	 * 我们在删除它之前把它存储在temp变量中，并且返回temp值
	 */
	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	/*
	 * 为了显示链表，从first开始，沿着引用链从一个链结点到下一个链结点，变量current按顺序指向（引用）每一个链结点。
	 */
	public void displayList() {
		System.out.print("List (first-->last):");
		Link current = first;
		while(current !=null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}
}
