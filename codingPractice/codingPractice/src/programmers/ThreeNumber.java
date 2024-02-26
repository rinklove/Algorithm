package programmers;

import java.util.ArrayList;

public class ThreeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//3진법
		int n =125;
		int answer = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(n >= 3) {
			System.out.println(n);
			list.add(n % 3);
			n /= 3;
		}
		list.add(n);
		for(int i =0; i<list.size(); i++) {
			answer += (list.get(list.size()-1-i) * Math.pow(3, i));
		}
		System.out.println(answer);
	}
}