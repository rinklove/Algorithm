/*
    answer => 서버가 증설된 횟수
*/
class Solution {
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];
        
        for(int i = 0; i < players.length; i++) {
            int leastServer = players[i] / m;
            if(leastServer > servers[i]) {
                //서버 증설 필요
                int addedServer = leastServer - servers[i];
                answer += addedServer;
                setServerOperatingHour(servers, i, k, addedServer);
            }
        }
        
        return answer;
    }
    
    private void setServerOperatingHour(int[] servers, 
                                        int current, 
                                        int k, 
                                       int addServer) {
        int operationHour = Math.min(current + k, servers.length);
        for(int i = current; i < operationHour; i++) {
            servers[i] += addServer;
        }
    }
}