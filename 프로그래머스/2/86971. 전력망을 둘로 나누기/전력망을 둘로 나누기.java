/*
    인접 리스트로 구현을 한다면?
*/
import java.util.*;

class Solution {
    private final Map<Integer, List<Integer>> map = new HashMap<>();
    private int[][] node;
    public int solution(int n, int[][] wires) {
        node = new int[n+1][n+1];
        setMap(wires);
        int answer = 101;
        
        for(int[] wire : wires) {
            boolean[] visited = new boolean[n+1];
            int num = getNode(wire[0], wire[1], visited);
            answer = Math.min(answer, Math.abs(num-(n-num)));
        }
        
        return answer;
    }
    
    private int getNode(int start, int end, boolean[] visited) {
        if(node[start][end] != 0) {
            return node[start][end];
        }
        if(start == end) {
            return 0;
        }
        
        visited[start] = true;
        int count = 1;
        List<Integer> list = map.get(start);
        for(int i : list) {
            if(!visited[i]) {
                count += getNode(i, end, visited);   
                node[start][end] = count;
            }
        }
        return count;
    }
    
    private void setMap(int[][] wires) {
        for(int[] wire : wires) {
            map.computeIfAbsent(wire[0], k -> new ArrayList<>()).add(wire[1]);
            map.computeIfAbsent(wire[1], k -> new ArrayList<>()).add(wire[0]);
        }
    }
}