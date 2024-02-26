package programmers;

import java.util.ArrayList;
import java.util.List;

public class 피보나치_수 {

	public static void main(String[] args) {
		//왜 하필 1234567로 나누지
		int n = 10000;
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(0);
		list.add(1);
		
		for(int number = 2; number <= n; number++) {
			list.add((list.get(number-2) +list.get(number-1)) %1234567);
		}
		System.out.println(list.get(n));
	}
}
