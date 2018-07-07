package com.ageeklet.dataStructure.link.doubleSideChainTable;

public class Link {
	public long dData;
	public Link next;
	
	public Link(long d) {
		this.dData = d;
	}
	
	public void displayLink() {
		System.out.print(dData+" ");
	}
}
