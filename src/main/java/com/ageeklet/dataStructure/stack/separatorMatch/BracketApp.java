package com.ageeklet.dataStructure.stack.separatorMatch;

import java.io.IOException;

import com.ageeklet.dataStructure.stack.StackX;

public class BracketApp {
	public static void main(String[] args) throws IOException {
		String input;
		while(true) {
			System.out.print("Enter string cotaining delimiters:");
			System.out.flush();
			input = StackX.getString();
			if(input.equals("")) {
				break;
			}
			BracketChecker theChecker = new BracketChecker(input);
			theChecker.check();
		}
	}
}
