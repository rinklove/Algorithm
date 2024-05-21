import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pick  = nums.length/2;
		
		int length = (int) Arrays.stream(nums).distinct().count();
		answer = pick <= length? pick : length;
        return answer;
    }
}