class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int d = 3; d < dp.length; d++) {
            dp[d] = (dp[d-1] + dp[d-2]) % 1000000007;
        }
        return dp[n];
    }
}