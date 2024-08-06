class Solution {
    private boolean[][] chessMap;
    private int count;
    public int solution(int n) {
        chessMap = new boolean[n][n];
        search(0, 0);
        return count;
    }
    
    private void search(int depth, int cnt) {
        if(depth == chessMap.length) {
            if(cnt == chessMap.length) {
                count++;
            }
            return;
        }
        
        for(int i = 0; i < chessMap[depth].length; i++) {
            if(isSafe(depth, i)) {
                setQueen(depth, i, true);
                search(depth+1, cnt+1);
                setQueen(depth, i, false);
            }
        }
    }
    
    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chessMap[i][col]) {
                return false;
            }
            if (col - (row - i) >= 0 && chessMap[i][col - (row - i)]) {
                return false;
            }
            if (col + (row - i) < chessMap.length && chessMap[i][col + (row - i)]) {
                return false;
            }
        }
        return true;
    }
    
    private void setQueen(int depth, int i, boolean value) {
        chessMap[depth][i] = value;
    }
    
    private boolean isValid(int i, int j) {
        return i >= 0 && i < chessMap.length && j >= 0 && j < chessMap[0].length;
    }
}