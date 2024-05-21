import java.util.stream.IntStream;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
		
		int middleNum = total / num;
		answer = num % 2 ==0 ? IntStream.rangeClosed(middleNum-(num/2-1), middleNum+(num/2)).toArray()
				: IntStream.rangeClosed(middleNum-(num/2), middleNum+(num/2)).toArray();
        return answer;
    }
}