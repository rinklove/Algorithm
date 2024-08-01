class Solution
{
    public int solution(int[][] board) {
        int answer = 0;
        answer = getMaxLength(board);
        return answer;
    }
    
    private int getMaxLength(int[][] board) {
        int max = 0;
        int[][] dp = new int[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++) {
            dp[i][0] = board[i][0];
            if(dp[i][0] == 1) max = 1;
        }
        
        for(int i = 0; i < board[0].length; i++) {
            dp[0][i] = board[0][i];
            if(dp[0][i] == 1) max = 1;
        }
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], 
                                        Math.min(dp[i][j-1], dp[i-1][j])) + 1; 
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = 0;
                }   
            }
        }
        
        return max*max;
    }
}