package baekjoon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
		
//		Map<Integer,Integer> xMap = new HashMap<Integer, Integer>();
//		Map<Integer,Integer> yMap = new HashMap<Integer, Integer>();
//		
//		for(int i = 0; i < N; i++) {
//			int x1 = sc.nextInt();
//			int y1 = sc.nextInt();
//			int x2 = sc.nextInt();
//			int y2 = sc.nextInt();
//			
//			for(int j = x1; j <= x2; j++) {
//				xMap.put(j, xMap.getOrDefault(j, 0)+1);
//			}
//			
//			for(int j = y1; j <= y2; j++) {
//				yMap.put(j, yMap.getOrDefault(j, 0)+1);
//			}
//		}
//		
//		System.out.println(xMap);
//		System.out.println(yMap);
//		
//		 int xCount = (int) xMap.entrySet().stream().filter(e -> e.getValue() > M).mapToInt(e -> e.getKey()).count();
//		 int yCount = (int) yMap.entrySet().stream().filter(e -> e.getValue() > M).mapToInt(e -> e.getKey()).count();
//		 
//		 //중간에 빈 사각형을 빼야함
//		 System.out.println(xCount);
//		 System.out.println(yCount);
//		-----------------------------------------------------------------------------------------------
		int[][] map = new int[100][100];
		
		for(int i = 0; i < N; i ++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int j = y1; j <=y2; j++) {
				for(int k = x1; k <= x2; k++) {
					map[j][k]++;
				}
			}
		}
		
		int count = (int) Arrays.stream(map).flatMapToInt(Arrays::stream).filter(n -> n > M).count();
		System.out.println(count);
		
	}
}
