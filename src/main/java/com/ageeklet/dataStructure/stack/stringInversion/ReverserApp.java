package com.ageeklet.dataStructure.stack.stringInversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ageeklet.dataStructure.stack.StackX;

public class ReverserApp {

	public static void main(String[] args) throws IOException {
		String input,output;
		while(true) {
			System.out.print("Enter a string:");
			System.out.flush();;
			input = StackX.getString();
			if(input.isEmpty()) {
				break;
			}
			Reverser theReverser = new Reverser(input);
			output = theReverser.doReverser();
			System.out.println("Reverserd:" + output);
		}
	}
}
