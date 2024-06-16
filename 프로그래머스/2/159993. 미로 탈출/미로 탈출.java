/*
    bfs
    시작 지점 -> 레버 -> 출구
*/
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        boolean flag = false;
        int[] start = findStart(maps);
        int startX = start[0], startY = start[1];
        int first = 0, second = 0;
        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'L') {
                    first = getDistance(maps, startX, startY, flag);
                    if(first > 0) {
                        flag = true;
                        second = getDistance(maps, i, j, flag);
                    }
                }
                
                if(!(first != -1 && second != -1)) {
                    return -1;
                }
            }
        }
        return first+second;
    }
    
    private int getDistance(String[] map, int startX, int startY, boolean flag) {
        int distance = 0;
        int xLength = map.length;
        int yLength = map[0].length();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char end = flag ? 'E' : 'L';
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[xLength][yLength];

        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int s = 0; s < size; s++) {
                int[] poll = q.poll();
                int x = poll[0];
                int y = poll[1];
                
                if(map[x].charAt(y) == end) return distance;
                
                for(int d = 0; d < 4; d++) {
                    int newX = x + dx[d];
                    int newY = y + dy[d];
                    
                    if(valid(newX, newY, xLength, yLength) && 
                       map[newX].charAt(newY) != 'X' && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            distance++;
        }
        return -1;
    }
    
    private boolean valid(int curX, int curY, int xLength, int yLength) {
        return curX >= 0 && curX < xLength && curY >= 0 && curY < yLength;
    }
    
    private int[] findStart(String[] maps) {
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(maps[i].charAt(j) == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}