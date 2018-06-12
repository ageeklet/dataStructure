package com.ageeklet.dataStructure.order;

/**
 * 在有序数组中，使用二分法查找某一个数
 * @author ageeklet
 *
 */
public class OrderArray {
	private long[] a;
	private int nElems;//数组中内容数量
	
	public OrderArray(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public int size() {
		return nElems;
	}
	
	//二分法查找：searchKey为要查找的数
	public int find(long searchKey) {
		int lowerBound = 0;//最小值
		int upperBound = nElems-1;//最大值
		int curIn;//中间数
		
		while(true) {
			curIn = (lowerBound+upperBound)/2;
			if(a[curIn]==searchKey) {
				return curIn;
			}else if(lowerBound>upperBound) {
				return nElems;
			}else {
				if(a[curIn]<searchKey) {
					lowerBound = curIn+1;
				}else {
					upperBound = curIn-1;
				}
			}
		}
	}
	
	/*
	 *向数组中插入数据
	 *每执行一次insert方法，nElems就会增加1 
	 */
	public void insert(long value) {
		int j ;
		for(j=0;j<nElems;j++) {
			if(a[j]>value) {
				break;
			}
		}
		for(int k=nElems;k>j;k--) {
			a[k] = a[k-1];
		}
		a[j] = value;
		nElems++;
	}
	
	//删除数组中的数据项
	public boolean delete(long value) {
		int j = find(value);
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
