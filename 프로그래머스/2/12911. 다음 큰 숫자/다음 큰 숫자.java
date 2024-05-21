class Solution {
    public int solution(int n) {
        int answer = n;
		int binaryN = Integer.bitCount(n);

		while (true) {
			answer++;
			int binaryCount = Integer.bitCount(answer);
			if (binaryN == binaryCount)
				break;
		}
        return answer;
    }
}