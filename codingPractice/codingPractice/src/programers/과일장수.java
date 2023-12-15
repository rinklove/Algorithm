package programers;

import java.util.Arrays;

public class 과일장수 {
	
	//과일 장수
	public static void main(String[] args) {
		
		int k = 4;
		int m = 3;
		int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
		int answer = 0;
		
		Arrays.sort(score);
		
		for(int i = score.length-m; i >= 0; i -= m) {
			System.out.println(score[i]*m);
			answer += (score[i]*m);
		}
		System.out.println(answer);
	}

}
