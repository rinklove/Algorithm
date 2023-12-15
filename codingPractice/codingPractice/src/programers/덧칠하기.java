package programers;

public class 덧칠하기 {

	/**
	 * 덧칠하기
	 */
	public static void main(String[] args) {

		//롤러는 이 범위 내에서만 움직일텐데?
		// 모든 구역에 대해서 일치하는 값 조사 후 롤러를 그어야 하나?
		int[] section = {2, 3, 6};
		int m = 4;
		int answer = 0;
		int range = section[section.length-1 ]- section[0] + 1;
		
		answer = range / m;
		if(range % m != 0 ) {
			answer++;
		}
		
		
	}

}
