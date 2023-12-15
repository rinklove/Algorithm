package codeup;

import java.util.Scanner;

public class ArrayTwice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<arr.length; i++ ) {
			arr[i] = sc.nextInt();
		}
		for(int i =0;i<2;i++) {
			for(int j=0; j<arr.length;j++) {
				System.out.println(arr[j]);
			}
		}
	}

}
