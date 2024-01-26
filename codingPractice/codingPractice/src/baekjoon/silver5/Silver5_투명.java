package baekjoon.silver5;

import java.util.Arrays;
import java.util.Scanner;

public class Silver5_투명 {

	public static void main(String[] args) {
		
		//전체 개수 10000개
		//21 80
//		41 60 -> 400
//		71 90 -> 71 80 -> 100
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	//불투명한 종이 개수
		int M = sc.nextInt();	//M+1장 부터 안보임
	
		int[][] map = new int[100][100];
		
		for(int i = 0; i < N; i ++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int j = y1; j <=y2; j++) {
				for(int k = x1; k <= x2; k++) {
					map[j-1][k-1]++;
				}
			}
		}
		
		int count = (int) Arrays.stream(map).flatMapToInt(Arrays::stream).filter(n -> n > M).count();
		System.out.println(count);
		
	}
}
