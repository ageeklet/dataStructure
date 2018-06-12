package com.ageeklet.dataStructure.array_02;

public class LowArrayApp {
	public static void main(String[] args) {
		LowArray lowArray = new LowArray(100);
		int nElems = 0;
		int j ;
		lowArray.setElem(0, 77);
		lowArray.setElem(1, 99);
		lowArray.setElem(2, 44);
		lowArray.setElem(3, 55);
		lowArray.setElem(4, 22);
		lowArray.setElem(5, 88);
		lowArray.setElem(6, 11);
		lowArray.setElem(7, 00);
		lowArray.setElem(8, 66);
		lowArray.setElem(9, 33);
		nElems = 10;
		//显示数组内容
		for(j=0;j<nElems;j++) {
			System.out.print(lowArray.getElem(j)+" ");
		}
		System.out.println(" ");
		//查询数组中内容
		int searchKey = 26;
		for(j=0;j<nElems;j++) {
			if(lowArray.getElem(j)==searchKey) {
				break;
			}
		}
		if(j==nElems) {
			System.out.println("Can`t find "+searchKey);
		}else {
			System.out.println("Found "+searchKey);
		}
		//删除数组中的内容
		searchKey=55;
		for(j=0;j<nElems;j++) {
			if(lowArray.getElem(j)==searchKey) {
				break;
			}
		}
		for(int k=j;k<nElems;k++) {
			lowArray.setElem(k, lowArray.getElem(k+1));
		}
		nElems--;
		//显示删除后的数组内容
		for(j=0;j<nElems;j++) {
			System.out.print(lowArray.getElem(j)+" ");
		}
		System.out.println(" ");
	}
}
