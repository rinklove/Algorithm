package baekjoon;

import java.util.Scanner;

public class 적어도_대부분의_배수 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] a = new int[5];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		int answer = 1;
		int count = 0;
		do {
			answer++;
			count = 0;
			
			for(int i = 0; i < a.length; i++) {
				if(answer % a[i] == 0) {
					count++;
				}
			}
		} while(count < 3);
		
		System.out.println(answer);
	}
	
}
