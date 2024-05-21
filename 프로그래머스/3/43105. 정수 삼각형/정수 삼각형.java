class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
		
		for(int depth = triangle.length-1; depth > 0; depth--) {
			for(int width = 0; width < triangle[depth-1].length; width++) {
				triangle[depth-1][width] += Math.max(triangle[depth][width], triangle[depth][width+1]);
			}
		}
		
		answer = triangle[0][0];
        return answer;
    }
}