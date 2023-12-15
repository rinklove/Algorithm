package programers;

import java.util.HashSet;
import java.util.Set;

public class 기사단원의_무기 {

	public static void main(String[] args) {

		// 1, 2, 3, 4, 5 => 연산을 줄이는 방버 
		int number = 10;
		int limit = 3;
		int power = 2;
		int answer =0;
		Set<Integer> set = new HashSet<>();
		
		for(int n = 1; n <=number; n++) {
			for(int divide =1; divide <=  Math.sqrt(n); divide++) {
				if(n % divide == 0) {
					set.add(divide);
					set.add(n/divide);
				}
			}
			answer += set.size() > limit ? power : set.size();
			set.clear();
		}
		
		System.out.println(answer);
	}

}
