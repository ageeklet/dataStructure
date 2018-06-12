package com.ageeklet.dataStructure.array_03;

public class HighArray {

	private long[] a;
	private int nElems;
	
	public HighArray(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	//查询数组内容
	public boolean find(long searchKey) {
		int j ;
		for(j=0;j<nElems;j++) {
			if(a[j]==searchKey) {
				break;
			}
		}
		if(j==nElems) {
			return false;
		}else {
			return true;
		}
	}
	
	//向数组中插入数据
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	//删除数组中的数据项
	public boolean delete(long value) {
		int j ;
		for(j=0;j<nElems;j++) {
			if(value==a[j]) {
				break;
			}
		}
		if(j==nElems) {
			return false;
		}else {
			for(int k=j;k<nElems;k++) {
				a[k]=a[k+1];
			}
			nElems--;
			return true;
		}
	}
	public void display() {
		for(int j=0;j<nElems;j++) {
			System.out.print(a[j]+" ");
		}
		System.out.println(" ");
	}
	
}









