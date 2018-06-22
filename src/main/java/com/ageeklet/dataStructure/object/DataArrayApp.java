package com.ageeklet.dataStructure.object;

public class DataArrayApp {

	public static void main(String[] args) {
		int maxSize = 100;
		ClassDataArray arr = new ClassDataArray(maxSize);
		
		arr.insert("aa", "bb", 3);
		arr.insert("cc", "dd", 4);
		arr.insert("ee", "ff", 5);
		arr.insert("gg", "hh", 6);
		arr.insert("ii", "jj", 7);
		arr.insert("kk", "mm", 8);
		arr.insert("ll", "nn", 9);
		arr.insert("xx", "yy", 10);
		arr.insert("vv", "zz", 11);
		arr.insert("ab", "cd", 12);
		
		arr.displayA();
		
		String searchKey = "cc";
		Person found = arr.find(searchKey);
		if(found!=null) {
			System.out.println("Found "+found);
			found.displayPerson();
		}else {
			System.out.println("Can`t found"+found);
		}
		
		arr.delete("ll");
		
		arr.displayA();
		
	}
}
