package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class 두개_뽑아서_더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TreeSet을 찾아보고 공부해야할 듯
		int[] answer = {};
		int[]  numbers = {2,1,3,4,1};
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i<numbers.length-1;i++) {
			for(int j = i+1; j<numbers.length;j++) {
				if(result.indexOf(numbers[i]+numbers[j]) == -1)
					result.add(numbers[i]+numbers[j]);
			}
		}
		result.sort(null);
		answer = new int[result.size()];
		for(int i = 0; i<answer.length; i++) {
			answer[i] = result.get(i);
		}
		
	}

}
