import java.util.*;

class Solution {
    private int[][] map;
    public int solution(int n, int[][] costs) {

        initMap(n, costs);  // 비용 맵 초기화


        return getCost(n);
    }

    private void initMap(int n, int[][] costs) {
        map = new int[n][n];

        for (int[] cost : costs) {
            int island1 = cost[0];
            int island2 = cost[1];
            int c = cost[2];

            map[island1][island2] = c;
            map[island2][island1] = c;
        }
    }
    
    //프림 알고리즘! - 최소 비용을 구해주는 알고리즘
    private int getCost(int n) {
        //비용을 기준으로 하여 오름차순으로 정렬해주는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(c -> c[2]));
        //방문 여부 체크하는 변수
        boolean[] visited = new boolean[n];
        int result = 0;
        
        //초기 상태에서 첫번째 섬 방문;
        visited[0] = true;
        for(int i = 0; i < map[0].length; i++) {
            if(map[0][i] > 0) {
                pq.offer(new int[]{0, i, map[0][i]});
            }
        }
        
        while(!pq.isEmpty()) {
            int[] poll = pq.poll();
            int from = poll[0];
            int to = poll[1];
            int cost = poll[2];
            
            //이미 방문한 섬이면 패스
            if(visited[to]) continue; 
            
            //방문하지 않은 섬에 대해서 최소 비용을 탐색.
            visited[to] = true;
            result += cost;
            for(int i = 0; i < map[to].length; i++) {
                if(!visited[i] && map[to][i] > 0) {
                    pq.offer(new int[]{to, i, map[to][i]});
                }
            }
        }
        return result;
    }
}
