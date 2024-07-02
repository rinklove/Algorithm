class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] original = new long[1001];
        long[] total = new long[4001];
        
        for(int i = 0; i < weights.length; i++) {
            int current = weights[i];
            long tmp = original[current];
            int time2 = current*2;
            int time3 = current*3;
            int time4 = current*4;
            if(tmp > 0) {
                answer += tmp;
                answer += total[time2] - tmp;
                answer += total[time3] - tmp;
                answer += total[time4] - tmp;
            } else {
                answer += total[time2];
                answer += total[time3];
                answer += total[time4];
            }
            
            original[current]++;
            total[time2]++;
            total[time3]++;
            total[time4]++;
        }

        return answer;
    }
}