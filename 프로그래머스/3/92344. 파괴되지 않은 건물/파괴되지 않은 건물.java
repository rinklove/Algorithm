class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] sums = new int[board.length + 1][board[0].length + 1];
        setSums(sums, skill);
        return checkBoard(board, sums);
    }
    
    private int checkBoard(int[][] board, int[][] sums) {
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] + sums[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private void setSums(int[][] sums, int[][] skills) {
        for(int[] skill : skills) {
            skill[5] *= checkType(skill[0]);
            int x1 = skill[1];
            int y1 = skill[2];
            int x2 = skill[3];
            int y2 = skill[4];
            
            sums[x1][y1] += skill[5];
            sums[x1][y2+1] -= skill[5];
            sums[x2+1][y1] -= skill[5];
            sums[x2+1][y2+1] += skill[5]; 
        }
        
        for(int i = 0; i < sums.length; i++) {
            for(int j = 1; j < sums[i].length; j++) {
                sums[i][j] += sums[i][j-1];
            }
        }
        
        for(int j = 0; j < sums[0].length; j++) {
            for(int i = 1; i < sums.length; i++) {
                sums[i][j] += sums[i-1][j];
            }
        }
    }
    
    private int checkType(int type) {
        return type == 1 ? -1 : 1; 
    }
}