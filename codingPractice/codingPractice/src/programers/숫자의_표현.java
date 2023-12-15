package programers;

public class 숫자의_표현 {

	public static void main(String[] args) {
		//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 -> 최대 5개에서 해야함. 6개는
		//재귀? 등차수열?  -> 등차수열에서 한대 맞음
		int n = 15;
		int answer = 1;
		int round = (int) Math.round((double) n / 2);
		
		if(n != 1) {
			for(int i = 1; i <= round; i++) {
				int tmp = (int) Math.floor(Math.sqrt(2*n+(Math.pow(i, 2)-i)));
				
				if(tmp * (tmp + 1) == 2 * n + Math.pow(i, 2)-i) answer++;
			}			
		}
		System.out.println(answer);
//		M
	}

}
