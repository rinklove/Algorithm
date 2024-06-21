import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    private int bfs(int[][] map) {
        int count = 0;
        int exitRow = map.length;
        int exitCol = map[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[exitRow][exitCol];
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            count++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int row = poll[0];
                int col = poll[1];
                
                if(row == exitRow-1 && col == exitCol-1) return count;
                
                for(int d = 0; d < 4; d++) {
                    int dRow = row+dr[d];
                    int dCol = col+dc[d];
                    
                    if(valid(dRow, dCol, exitRow, exitCol) && !visited[dRow][dCol]
                      && map[dRow][dCol] == 1) {
                        visited[dRow][dCol] = true;
                        q.offer(new int[] {dRow, dCol});
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean valid(int row, int col, int exitRow, int exitCol) {
        return row >= 0 && row < exitRow && col >= 0 && col < exitCol;
    }
}