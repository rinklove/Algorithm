package codeup;

import java.util.Scanner;

public class Main1093 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int[] count = new int[23];
		
		int num = sc.nextInt();
		for(int i =0; i<num; i++) {
			int student = sc.nextInt();
			count[student-1]++;
		}
		
		for(int i=0;i<count.length;i++) {
			System.out.print(count[i] + " ");
		}
	}

}
