package programers;

import java.util.Arrays;

public class MakeMaxNum {

	
	public static void main(String[] args) {
		
		int[] numbers = {1, 2, -3, 4, -5};
		int answer = 0;
		numbers = Arrays.stream(numbers).sorted().toArray();
		
		int max1 = numbers[0] * numbers[1];
		int max2 = numbers[numbers.length-1] * numbers[numbers.length-2];
		answer = Math.max(max1, max2);
		
		System.out.println(answer);
	}
}
