package baekjoon;

import java.util.Scanner;

public class Silver5_날짜계산 {

	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		
		// 1-16-16 / 2-17-17 / 3-18-18 / 4-19-19 / 5-20-1
		//(N % 16) + (올림수) = 1 / (N % 29) = 16
		int E = sc.nextInt();	//1 ~ 15
		int S = sc.nextInt();	//1 ~ 28
		int M = sc.nextInt();	//1 ~ 19
		sc.close();
		
		//올림수
		int upE = 0;
		int upS = 0;
		int upM = 0;
		
		//현재 년도
		int N = 1;
		int currentE = 1;
		int currentS = 1;
		int currentM = 1;
		
		while(!(currentE == E && currentS == S && currentM == M)) {
			
		}
	}
}
