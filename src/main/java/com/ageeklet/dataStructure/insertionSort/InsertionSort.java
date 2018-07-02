package com.ageeklet.dataStructure.insertionSort;

public class InsertionSort {
	/*
	    1、从第一个元素开始，该元素可以认为已经被排序
		2、取出下一个元素，在已经排序的元素序列中从后向前扫描
		3、如果该元素（已排序）大于新元素，将该元素移到下一位置
		4、重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置
		5、将新元素插入到该位置后
		6、重复步骤 2~5
	 */
	public static void insertionSort_1(int[] arr) {
		for(int i=1;i<arr.length;i++){
			int key = arr[i];  //key为当前索引对应的数组中的值
			int j = i-1;	   //j为当前索引的前一位
			while(j>=0 && arr[j]>key) {  //判断索引i对应的数组中的值是否小于前一位
				arr[j+1] = arr[j];  //   交换前后两个索引对应的数组中的值
				j--;
			}
			arr[j+1] = key;
		}
	}
	
	public  static void insertionSort_2(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			 //如果将赋值放到下一行的for循环内, 会导致在第10行出现j未声明的错误
			for (; j>=0 && arr[j]>temp ; j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
	}
	public static void main(String[] args) {
		int[] arr = {5, 6, 3, 1, 8, 7, 2, 4};
		insertionSort_1(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		insertionSort_2(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
