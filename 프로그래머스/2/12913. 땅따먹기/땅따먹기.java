class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][land[0].length];
        //첫 행을 밟았을 때의 얻는 점수 초기화. 
        for(int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }
        
        //두번째 행부터 각 칸을 밟을 때의 얻을 수 있는 최대 점수를 갱신함.
        for(int d = 1; d < dp.length; d++) {
            for(int i = 0; i <dp[d].length; i++) {
                for(int n = 0; n < land[d].length; n++) {
                    if(i == n) continue;
                    dp[d][i] = Math.max(dp[d][i], dp[d-1][n]+land[d][i]);
                }
            }
        }
        
        //마지막 열에서 가장 많은 점수를 얻을 수 있는 칸 출력.
        for(int d : dp[dp.length - 1]) {
            answer = Math.max(answer, d);
        }
        return answer;
    }
}