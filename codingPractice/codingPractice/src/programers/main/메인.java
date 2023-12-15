package programers.main;

import java.util.Arrays;

public class 메인 {

	public static void main(String[] args) {
		
		int[] number = {-2, 3, 0, 2, -5};
		int answer = 0;
		for(int first = 0; first < number.length-2; first++) {
			for(int second = first+1; second < number.length-1; second++) {
				for(int third = second+1; third < number.length; third++) {
					if(number[first]+number[second]+number[third] == 0) answer++;
				}
			}
		}
	}
}
