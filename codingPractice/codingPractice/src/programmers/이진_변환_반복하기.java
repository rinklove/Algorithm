package programmers;

import java.util.ArrayList;
import java.util.List;

public class 이진_변환_반복하기 {

	public static void main(String[] args) {
		
		String s = "110010101001";
		int[] answer = new int[2];
		while(true) {
			int before = s.length();
			s = s.replaceAll("0", "");
			int after = s.length();
			
			answer[1] += (before - after);
			
			s = Integer.toBinaryString(s.length());
			answer[0]++;
			if(s.equals("1")) break;
		}
	}

}
