package programmers;

import java.util.Arrays;

public class Rectangle {

	//직사각형 넓이 구하기
	public static void main(String[] args) {
		int[][] dots = {{1, 1}, {2, 1}, {2, 2}, {1, 2}};
		int answer = 0;
		int[] row = {dots[0][0], dots[1][0], dots[2][0], dots[3][0]};
		int[] col = {dots[0][1], dots[1][1], dots[2][1], dots[3][1]};
		
		row =Arrays.stream(row).distinct().sorted().toArray();
		col = Arrays.stream(col).distinct().sorted().toArray();
		
		answer = (row[1] - row[0]) * (col[1] - col[0]);
		System.out.println(answer);
	}
}
