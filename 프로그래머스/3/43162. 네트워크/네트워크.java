class Solution {
    
    private int[][] network;
    private boolean visited[][];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        network = new int[n][n];
        visited = new boolean[n][n];
        
        //네트워크 구성
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(computers[i][j] == 1) {
                    System.out.println("i = " + i + " j = "+ j);
                    network[i][j] = 1;
                }
            }
        }
        
        for(int i = 0; i < network.length; i++) {
            for(int j = 0; j < network[i].length; j++) {
                if(network[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    answer++;
                }
            }
        }
        return answer;
    }
    
    private void dfs(int from, int to) {
        visited[from][from] = true;
        visited[from][to] = true;
        visited[to][from] = true;
        
        for(int i = 0; i < network[to].length; i++) {
            if(network[to][i] == 1 && !visited[to][i]) {
                dfs(to, i);
            }
        }
    }
}