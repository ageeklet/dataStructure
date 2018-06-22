package com.ageeklet.dataStructure.selectionSort;

public class ArraySel {
	private long[] a;
	private int nElems;
	
	public ArraySel(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	public void display() {
		for(int j=0;j<nElems;j++) {
			System.out.print(a[j]+" ");
		}
		System.out.println(" ");
	}
	
	public void selectionSort() {
		int out,in,min;
		for(out=0;out<nElems-1;out++) {
			min = out;//未排序序列中最小数据数组下标
			for(in=out+1;in<nElems;in++) {//在未排序元素中继续寻找最小元素，并保存其下标
				if(a[in]<a[min]) {
					min=in;
				}
			}
			swap(out,min);
		}
	}
	public void swap(int one,int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}







