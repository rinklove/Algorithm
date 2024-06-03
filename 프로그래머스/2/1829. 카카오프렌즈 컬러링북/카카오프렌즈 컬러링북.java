import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private boolean[][] visited;
    public int[] solution(int m, int n, int[][] picture) {
        //0: 그림에 있는 영역 개수 / 1: 가장 넓은 영역의 칸 수
        int[] answer = new int[2];
        visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 0) continue;
                if(!visited[i][j]) {
                    answer[0]++;
                    //dfs로 같은 영역 개수 반환
                    int max = bfs(picture, i, j);
                    answer[1] = Math.max(max, answer[1]);
                }
            }
        }
        return answer;
    }
    
    private int bfs(int[][] picture, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int[] di = {0, 0, -1, 1};
        int[] dj = {-1, 1, 0, 0};
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            for(int m = 0; m < size; m++) {
                int[] curr = queue.poll();
                int currI = curr[0];
                int currJ = curr[1];
                int value = picture[currI][currJ];
                
                
                for(int n = 0; n < 4; n++) {
                    int newI = currI+di[n];
                    int newJ = currJ+dj[n];
                    
                    if(isValid(newI, newJ) && !visited[newI][newJ] && picture[newI][newJ] == value) {
                        queue.offer(new int[]{newI, newJ});
                        visited[newI][newJ] = true;
                    }
                }
            }
        }
        return count;
    }
    
    private boolean isValid(int i, int j) {
        return i >= 0 && i < visited.length && j >= 0 && j < visited[0].length;
    }
}