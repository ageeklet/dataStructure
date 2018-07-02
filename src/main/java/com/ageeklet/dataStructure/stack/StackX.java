package com.ageeklet.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 栈实例1：单词逆序
 * @author ageeklet
 */
public class StackX {
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public StackX(int maxSize) {
		this.maxSize = maxSize;
		stackArray = new char[maxSize];
		top = -1;
	}
	
	/*
	 * top的值+1，使他指向原顶端数据项上面的一个位置，并在这个位置存储一个数据项。
	 * top是在插入数据项之前递增的
	 */
	public void push(char j) {
		stackArray[++top] = j;
	}
	
	/*
	 * 返回top标识的数据项值，然后top-1，该方法有效的移出了数据项
	 * 虽然数据项仍然存在数组中（直到有新的数据项压入栈中覆盖这个数据项），但不能再访问他了
	 */
	public char pop() {
		return stackArray[top--];
	}
	
	/*
	 * 返回top所指的数据项的值，不对栈做任何改动
	 */
	public char peek() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top==-1);
	}
	
	public static String getString()throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();//只读取一行数据
		return s;
	}
}
