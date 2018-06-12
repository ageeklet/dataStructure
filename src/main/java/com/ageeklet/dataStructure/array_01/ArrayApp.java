package com.ageeklet.dataStructure.array_01;

public class ArrayApp {

		public static void main(String[] args) {
			long[] arr = new long[100];
			int nElems = 0;
			int j;
			long searchKey;
			
			//给数组中插入几条数据
			arr[0]=77;
			arr[1]=99;
			arr[2]=44;
			arr[3]=55;
			arr[4]=22;
			arr[5]=88;
			arr[6]=11;
			arr[7]=00;
			arr[8]=66;
			arr[9]=33;
			nElems=10;
			
			//显示数组内容
			for(j=0;j<nElems;j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println(" ");			
			//查询数组中内容
			searchKey = 66;
			for(j=0;j<nElems;j++) {
				if(arr[j]==searchKey) {
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
				if(arr[j]==searchKey) {
					break;
				}
			}
			for(int k=j;k<nElems;k++) {
				arr[k]=arr[k+1];
			}
			nElems--;
			
			//显示删除后的数组内容
			for(j=0;j<nElems;j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println(" ");
		}
}










