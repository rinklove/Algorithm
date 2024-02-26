package programmers;

public class 정수_삼각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Math.max 쓰면 안어려울 듯
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		int answer = 0;
		//depth = 4, width = 4
		for(int depth = triangle.length-1; depth > 0; depth--) {
			for(int width = 0; width < triangle[depth-1].length; width++) {
				System.out.println("depth="+depth+"/ width="+width);
				triangle[depth-1][width] += Math.max(triangle[depth][width], triangle[depth][width+1]);
			}
		}
		answer = triangle[0][0];
		System.out.println(answer);
	}

}
