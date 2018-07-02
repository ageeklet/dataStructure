package com.ageeklet.dataStructure.stack.separatorMatch;

import com.ageeklet.dataStructure.stack.StackX;

/**
 * 分隔符匹配
 * @author ageeklet
 *
 */
public class BracketChecker {
	private String input;
	
	public BracketChecker (String in) {
		this.input = in;
	}
	
	public void check() {
		int stackSize = input.length();
		StackX theStack = new StackX(stackSize);
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case '{':
			case '[':
			case '(':
				theStack.push(ch);
				break;
				
			case '}':
			case ']':
			case ')':
				if(!theStack.isEmpty()) {
					char chx = theStack.pop();
					if((ch=='}' && chx!='{') || (ch==']' && chx!='[' )|| (ch==')' && chx!='(')) {
						System.out.println("Error: "+ch+" at "+i);
					}
					break;
				}else {
					System.out.println("Error: "+ch+" at "+i);
				}
				default:
					break;
			}
		}
		if(!theStack.isEmpty()) {
			System.out.println("Error:missing right delimiter");
		}
	}
}
