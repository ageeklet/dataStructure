package com.ageeklet.dataStructure.link;

public class Link {
	public long dData;
	public Link next;
	
	public Link(Long dd) {
		this.dData = dd;
	}
	
	public void displayLink() {
		System.out.print(dData+" ");
	}
}
