/*
    최단 거리? -> bfs
    데이터의 길이가 길다 -> 메모이제이션 필요
    1차 시도 메모리 초과 -> 인접 배열에서 인접 리스트로 구현
*/
import java.util.*;

class Solution {
    private List<List<Integer>> map;
    private final Map<Integer, Integer> distances = new HashMap<>();
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        setRoad(roads, n);
        
        setDistance(n, destination);
        getDistance(answer, sources);
        
        return answer;
    }
    
    private void getDistance(int[] answer, int[] sources) {
        for(int i = 0; i < answer.length; i++) {
            answer[i] = distances.getOrDefault(sources[i], -1);
        }
    }
    
    private void setDistance(int n, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        int distance = 0;
        distances.put(start, distance);
        
        while(!q.isEmpty()) {
            int size = q.size();
            distance++;
            for(int s = 0; s < size; s++) {
                int current = q.poll();
                
                for(int i : map.get(current)) {
                    if(!distances.containsKey(i)) {
                        distances.put(i, distance);
                        q.offer(i);
                    }
                }
            }
        }
    }
    
    private void setRoad(int[][] road, int n) {
        map = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        
        for(int[] r : road) {
            int re1 = r[0];
            int re2 = r[1];
            
            map.get(re1).add(re2);
            map.get(re2).add(re1);
        }
    }
}