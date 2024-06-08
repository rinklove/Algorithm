/*
    [[5,3],[3,10],[10,6],[6,8]]
    일단 dp 배열은 [n-1][n-1]크기로 설정
    ab bc cd
    abc bcd
    abcd
    150 180 480
    270(ab * c) / 324(bc * d)
    270 (abc *d) / (a * bcd)
    [[5*3*10][3*10*6][10*6*8]]
    [[5*3*10/10*6]]
    
    [[5,3],[3,10],[10,6]]
    [[150][180]]
    
    i = 2 / 3
    j = 0 ~ 1 / 0
*/
class Solution {
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        int n = matrix_sizes.length;
        int[][] dp = new int[n][n];
        
        // i = 행렬곱의 길이, j = 묶인 행렬곱의 시작 k = 배열의 분할점, target은 추가할 배열
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= n - i; j++) {
                int target = j + i - 1;
                dp[j][target] = Integer.MAX_VALUE;
                
                for(int k = j; k < target; k++) {
                    int cost = dp[j][k] + dp[k+1][target] + matrix_sizes[j][0] * matrix_sizes[k][1] * matrix_sizes[target][1];
                    dp[j][target] = Math.min(dp[j][target], cost);
                }
            }
        }
        
        // for(int[] d : dp) {
        //     for(int num : d) {
        //         System.out.print(num +" ");
        //     }
        //     System.out.println();
        // }
        return dp[0][n-1];
    }
}