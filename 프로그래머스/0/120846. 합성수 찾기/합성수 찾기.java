import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        int[] arr = IntStream.rangeClosed(1, n).toArray();
		int answer = 0;
		
		for(int i = 1;i<arr.length;i++) {
			for(int j = 2;j<arr[i];j++) {
				if(arr[i] % j == 0) {
					answer++;
					break;
				}
			}
		}
        return answer;
    }
}