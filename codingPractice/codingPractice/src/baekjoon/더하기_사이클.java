package baekjoon;

import java.util.Scanner;

public class 더하기_사이클 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int cycle = num;
		
		int a = 0;
		int b = 0;
		int count = 0;
		do {
			a = cycle / 10;
			b= cycle % 10;
			
			cycle = b * 10 + ((a+ b) % 10);
			count++;
		} while(cycle != num);
		System.out.println(count);
	}
}
