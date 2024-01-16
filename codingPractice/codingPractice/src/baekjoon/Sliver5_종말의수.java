package baekjoon;

import java.util.Scanner;

public class Sliver5_종말의수 {

	public static void main(String[] args) {
		//666이 들어가는 가장 작은 수
		//15666 -> 16660이 돼야하는데? - 보류
		Scanner sc = new Scanner(System.in);
		int serize = sc.nextInt();
		sc.close();
		
		int left = 0;
		int upLeft = 0;
		int right = 0;
		int upRight = 0;
		int result = 0;
		StringBuilder sb = new StringBuilder("666");
		for(int index = 0; index < serize; index++) {
			int leftNum = Integer.parseInt(left+sb.toString());
			int rightNum = Integer.parseInt(sb.toString()+right);
			
			//오른쪽을 출력
			if(leftNum > rightNum) {
				result = rightNum;
				right++;
				if(right == 10) right = 1;
			} else {
				result = leftNum;
				left++;
			}
			System.out.println(index+"일 때 result = " + result);
		}
	}
}
