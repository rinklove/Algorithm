package programmers;


import java.util.Arrays;

public class 폰켓몬 {

	public static void main(String[] args) {
		
		int[] nums = {3,1,2,3};
		int answer = 0;
		int pick  = nums.length/2;
		
		int length = (int) Arrays.stream(nums).distinct().count();
		answer = pick <= length? pick : length;
	}
	
	
}
