class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[n][m];
        
        for(int[] p : puddles) {
            map[p[1]-1][p[0]-1] = -1;   
        }
        
        for(int i = 1; i < n; i++) {
            map[i][0] = map[i][0] == -1 | map[i-1][0] == -1 ? -1 : 1;
        }
        
        for(int j = 1; j < m; j++) {
            map[0][j] = map[0][j] == -1 | map[0][j-1] == -1 ? -1 : 1;
        }
    
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(map[i][j] != -1) {
                    int num1 = map[i-1][j] == -1 ? 0 : map[i-1][j];
                    int num2 = map[i][j-1] == -1 ? 0 : map[i][j-1];
                    
                    map[i][j] = num1+num2 == 0 ? -1 : (num1+num2) % 1000000007;
                }
            }
        }
        answer = map[n-1][m-1] == -1 ? 0 : map[n-1][m-1];
        
        return answer;
    }
}