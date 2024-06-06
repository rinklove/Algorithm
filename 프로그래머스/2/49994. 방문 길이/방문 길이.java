import java.util.Set;
import java.util.HashSet;

class Solution {
    private Set<String> log = new HashSet<>();
    public int solution(String dirs) {
        int answer = 0;
        
        //시작 좌표
        int startX = 0;
        int startY = 0;
        
        for(int i = 0; i < dirs.length(); i++) {
            //이동할 좌표
            int curX = startX;
            int curY = startY;
            
            //방향 지정
            char dir = dirs.charAt(i);
            switch(dir) {
                case 'U': curX++; break;
                case 'D': curX--; break;
                case 'L': curY--; break;
                default: curY++; break;
            }
            
            //이동 범위가 좌표 내에 있고
            if(isValid(curX, curY)) {
                String path = startX + "" + startY + "" + curX + "" + curY;
                String reverse = curX + "" + curY + "" + startX + "" + startY;
                
                //이전 위치에서 현재 위치로 이동한 적이 없을 경우 갱신 및 이동 거리 추가
                answer += isNewPath(path, reverse);
                startX = curX;
                startY = curY;
            }
        }
        return answer;
    }
    
    private int isNewPath(String path, String reverse) {
        if(!(log.contains(path) && log.contains(reverse))) {
            log.add(path);
            log.add(reverse);
            return 1;
        } else return 0; 
    }
    
    private boolean isValid(int curX, int curY) {
        return curX >= -5 && curX <= 5 && curY >= -5 && curY <= 5;
    }
}