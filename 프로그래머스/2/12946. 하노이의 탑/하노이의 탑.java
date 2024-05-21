import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<int[]> list;
    public int[][] solution(int n) {
        int[][] answer = {};
        list = new ArrayList<>();
        dfs(n, 1, 3, 2);
        answer = new int[list.size()][];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public void dfs(int n, int start, int to, int mid) {
        if(n == 1) {
            list.add(new int[]{start, to});
            return;
        }

        dfs(n-1, start, mid, to);
        list.add(new int[]{start, to});
        dfs(n-1, mid, to, start);
    }
}