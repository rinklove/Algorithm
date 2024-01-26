package baekjoon.silver5;

import java.util.Scanner;

public class Silver5_날짜계산 {

	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		
		// 1-16-16 / 2-17-17 / 3-18-18 / 4-19-19 / 5-20-1
		//(N % 16) + (올림수) = 1 / (N % 29) = 16
		int E = sc.nextInt()-1;	//1 ~ 15 -> 0 ~ 14
		int S = sc.nextInt()-1;	//1 ~ 28 -> 0 ~ 27
		int M = sc.nextInt()-1;	//1 ~ 19 -> 0 ~ 18
		sc.close();
		
		//현재 년도
		int N = 0;
		int currentE = 0;
		int currentS = 0;
		int currentM = 0;
		
		while(!(currentE == E && currentS == S && currentM == M)) {
			N++;
			currentE = (N % 15);
			currentS = (N % 28);
			currentM = (N % 19);
		}
		
		System.out.println(N+1);
	}
}
