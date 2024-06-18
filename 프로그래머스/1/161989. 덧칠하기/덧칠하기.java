class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int length = section.length;
		int start = section[0];
        
        int range = 1;
        for(int i = 1; i < length; i++) {
            range = section[i] - start + 1;
            if(range > m) {
                answer++;
                start = section[i];
                range = 1;
            }
        }
        if(range > 0) {
            answer++;
        }
                
        return answer;
    }
}