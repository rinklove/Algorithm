package codeup;

import java.util.Scanner;

public class Main1095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] count = new int[num];
		int min = Integer.MAX_VALUE;
		
		for(int i =count.length-1; i >=0; i--) {
			int student = sc.nextInt();
			//최소값 로직
			min = Math.min(min, student);
		}
			System.out.print(min);
	}

}
