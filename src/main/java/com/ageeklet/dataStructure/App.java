package com.ageeklet.dataStructure;

import java.util.Scanner;

/**
 * Hello world!
 */

public class App {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] arr = { { 13, 67, 6, 3, 11 }, { 13, 13, 5, 11, 8 }, { 10, 10, 10, 41, 41 }, { 2, 2, 10, 10, 33 },
				{ 13, 10, 13, 22, 34, 33 } };

		System.out.print("请输入横坐标：");
		int x = in.nextInt();
		System.out.print("请输入竖坐标：");
		int y = in.nextInt();

		int value = arr[x][y];

		System.out.println(value);

		for (int i = 0; i <= arr.length; i++) {
			for (int j = 0; j <= arr[i].length; j++) {
				if (arr[i][j] == value) {
					// System.out.print("("+i+","+j+")"+"\t");
					int[][] zb = { { i, j } };
					judge(zb);
				}
			}
		}
	}

	public static void judge(int[][] arr) {
		int[] x = new int[arr.length];
		int[] y = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i == 0) {
					x[j] = arr[i][j];
				} else {
					y[j] = arr[i][j];
				}
			}
		}
	}
}
