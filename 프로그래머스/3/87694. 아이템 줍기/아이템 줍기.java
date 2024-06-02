import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private int[][] map;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
    
        //가장 큰 값의 x,y 좌표를 각각 찾아서 지도 생성
        setMap(rectangle); 
        
        return findItem(characterX*2, characterY*2, itemX*2, itemY*2) / 2;
    } 
    
    //map 크기 설정
    private void setArea(int[][] rectangle) {
        int[] max = new int[2];
        for(int[] r : rectangle) {
            max[1] = Math.max(max[1], r[2]); //가장 큰 값의 x 좌표
            max[0] = Math.max(max[0], r[3]); //가장 큰 값의 y 좌표
        }
        //맵의 크기를 2배로 늘려서 경로의 정확성 확보
        map = new int[max[0]*2+2][max[1]*2+2];
    }
    
    private void setPath(int[] rec) {
        //x축 외곽 길 생성
        for(int i = rec[0]*2; i <= rec[2]*2; i++) {
            map[rec[1]*2][i]++;
            map[rec[3]*2][i]++;
        }
        //y축 외곽 길 생성
        for(int i = rec[1]*2+1; i < rec[3]*2; i++) {
            map[i][rec[0]*2]++;
            map[i][rec[2]*2]++;
        }
    }
    
    private void setMap(int[][] rectangle) {
        
        setArea(rectangle);
             
        for(int[] r : rectangle) {
            setPath(r);
        }
        
        for(int[] r : rectangle) {
            deleteInner(r);
        }
    }
    
    private void deleteInner(int[] rec) {
        for(int i = rec[1]*2+1; i < rec[3]*2; i++) {
            for(int j = rec[0]*2+1; j < rec[2]*2; j++) {
                map[i][j] = 0;
            }
        }
    }
    
    private int findItem(int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{characterX, characterY});
        visited[characterY][characterX] = true;
        int[] delX = {1, -1, 0, 0};
        int[] delY = {0, 0, -1, 1};
        
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                
                if(x == itemX && y == itemY) {
                    return count;
                }
                
                for(int j = 0; j < 4; j++) {
                    int dx = x+delX[j];
                    int dy = y+delY[j];
                    
                    if(isValid(dx, dy) && map[dy][dx] != 0 && !visited[dy][dx]) {
                        queue.offer(new int[]{dx, dy});
                        visited[dy][dx] = true;
                    }
                }
            }
            count++;
        }
        return 0;
    }
    
    private boolean isValid(int x, int y) {
        return x >= 0 && x < map[0].length && y >= 0 && y < map.length;
    }
}