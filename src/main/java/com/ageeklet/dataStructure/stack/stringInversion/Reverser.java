package com.ageeklet.dataStructure.stack.stringInversion;

import com.ageeklet.dataStructure.stack.StackX;

public class Reverser {
	private String input;
	private String output;
	
	public Reverser(String in) {
		this.input = in;
	}
	
	public String doReverser() {
		int stackSize = input.length();
		//创建一个栈
		StackX theStack = new StackX(stackSize);
		
		for (int i = 0; i < input.length(); i++) {
			//定位输入string中每个字符，并且将其存入到栈中
			char ch = input.charAt(i);
			theStack.push(ch);
		}
		output = "";
		while(!theStack.isEmpty()) {
			//得到栈顶元素，并且将其拼接成一个新的字符串，与原字符串刚好逆序
			char ch = theStack.pop();
			output = output + ch;
		}
		return output;
	}
}
