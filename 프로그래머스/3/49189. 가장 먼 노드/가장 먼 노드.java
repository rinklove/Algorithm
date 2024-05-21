import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    private boolean[] visited;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        boolean[][] line = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        for(int[] e : edge) {
            line[e[0]][e[1]] = true;
            line[e[1]][e[0]] = true;
        }
        
        answer = bfs(1, line);  
        return answer;
    }
    
    private int bfs(int node, boolean[][] line) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(node);
        visited[node] = true;
        
        /**
        23 -> 3 -> 345 -> 45 -> 4546 -> 546
        
        */
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            count = size; // 현재 레벨의 노드 수를 저장
            for (int i = 0; i < size; i++) {
                int n = queue.poll();

                for (int j = 1; j < line[n].length; j++) {
                    if (!visited[j] && line[n][j]) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
        }
        return count;
    }
}