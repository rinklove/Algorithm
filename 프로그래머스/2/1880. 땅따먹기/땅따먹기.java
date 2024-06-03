class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int[][] dp = new int[land.length][4];
        
        //초기 값 설정
        for(int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }
        
        //현재 위치한 땅 + 이전까지 밟아 온 땅들 중 누적 값이 가장 큰 값을 저장
        for(int i = 1; i < land.length; i++) {
            dp[i][0] = land[i][0] + Math.max(Math.max(dp[i-1][1], dp[i-1][2]), dp[i-1][3]);
            dp[i][1] = land[i][1] + Math.max(Math.max(dp[i-1][0], dp[i-1][2]), dp[i-1][3]);
            dp[i][2] = land[i][2] + Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][3]);
            dp[i][3] = land[i][3] + Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
        }

        //마지막행까지 수행 후 가장 큰 값 반환
        for(int d : dp[land.length-1]) {
            answer = Math.max(answer, d);
        }
        return answer;
    }
}