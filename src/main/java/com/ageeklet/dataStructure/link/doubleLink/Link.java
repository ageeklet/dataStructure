package com.ageeklet.dataStructure.link.doubleLink;

public class Link {
	public long dData;
	public Link previous;
	public Link next;
	
	public Link(long d) {
		this.dData = d;
	}
	
	public void displayLink() {
		System.out.print(dData+" ");
	}
}
