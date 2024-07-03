import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = init(board, m, n);
        
        while(true) {
            int count = search(map);    
            if(count == 0) break;
            answer += count;
            dropBlocks(map);
        }
        return answer;
    }
    
    private int search(char[][] map) {
        int m = map.length, n = map[0].length;
        boolean[][] toDelete = new boolean[m][n];
        
        for(int i = 0; i < m-1; i++) {
            for(int j = 0; j < n-1; j++) {
                if(canDelete(map, i, j)) {
                    toDelete[i][j] = true;
                    toDelete[i][j+1] = true;
                    toDelete[i+1][j] = true;
                    toDelete[i+1][j+1] = true;
                }
            }
        } 
        return delete(map, toDelete);
    }
    
    private int delete(char[][] map, boolean[][] toDelete) {
        int count = 0;
        int m = map.length, n = map[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(toDelete[i][j]) {
                    map[i][j] = ' ';
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dropBlocks(char[][] map) {
        Queue<Character> q = new LinkedList<>();
        int m = map.length, n = map[0].length;
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if(map[i][j] != ' ') {
                    q.offer(map[i][j]);
                }
            }
            
            for(int index = n-1; index >= 0; index--) {
                map[i][index] = q.isEmpty() ? ' ' : q.poll();
            }
        }
    }
    
    private boolean canDelete(char[][] map, int i, int j) {
        char target = map[i][j];
        if(target == ' ') return false;
        
        int count = 0;
        for(int x = i; x <= i+1; x++) {
            for(int y = j; y <= j+1; y++) {
                if(target != ' ' && target == map[x][y]) {
                    count++;
                }
            }
        }
        return count == 4;
    }
    
    private char[][] init(String[] board, int m, int n) {
        char[][] map = new char[n][m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map[j][i] = board[i].charAt(j);
            }
        }
        return map;
    }
}