package programmers;

public class MakeTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//가장 긴 변의 길이는 다른 두변의 길이의 합보다 작아야 한다
		/*
		 * sides 중 큰 값이 긴변일 경우 
		 * 두 변다 큰 값이 아닐 경우,
		 */
		int[] slides = {3, 6};
		int answer = 0;
		
		int max = Math.max(slides[0], slides[1]);
		int min = Math.min(slides[0], slides[1]);
		for(int i = 1; i < max; i ++) {
			if(min+i > max) answer++;
		}
		for(int i = max; i<max+min; i++) {
			answer++;
		}
		System.out.println(answer);
	}

}
