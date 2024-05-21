import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        numbers = Arrays.stream(numbers).sorted().toArray();
		
		int max1 = numbers[0] * numbers[1];
		int max2 = numbers[numbers.length-1] * numbers[numbers.length-2];
		answer = Math.max(max1, max2);
        return answer;
    }
}