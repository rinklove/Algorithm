package programers;

public class 평행 {

	public static void main(String[] args) {
		
		int[][] dots = { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 } };
		
		//사실 굳이 반복문으로 안해도 되긴 하는데
		//(01-23 // 02-13 // 12-03)
		int answer = 0;
		
		answer = (Math.abs((double)(dots[1][1] - dots[0][1]) / (double)(dots[1][0] - dots[0][0])) == Math.abs((double)(dots[3][1] - dots[2][1]) / (double)(dots[3][0] - dots[2][0]))) ||
					(Math.abs((double)(dots[2][1] - dots[0][1]) /(double) (dots[2][0] - dots[0][0])) == Math.abs((double)(dots[3][1] - dots[1][1]) /(double) (dots[3][0] - dots[1][0]))) ||
						(Math.abs((double)(dots[2][1] - dots[1][1]) / (double)(dots[2][0] - dots[1][0])) == Math.abs((double)(dots[3][1] - dots[0][1]) / (double)(dots[3][0] - dots[0][0]))) ? 1 : 0;
		
		System.out.println(answer);
	}
}
