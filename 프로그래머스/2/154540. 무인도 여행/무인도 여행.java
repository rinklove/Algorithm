import java.util.List;
import java.util.ArrayList;

class Solution {
    
    /**
    X591X
    X1X5X
    X231X
    1XXX1
    */
    private boolean[][] visited;
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        int height = maps.length;
        int width = maps[0].length();
        
        visited = new boolean[height][width];
        
        List<Integer> days = new ArrayList<>();
        for(int line = 0; line < height; line++) {
            for(int area = 0; area < width; area++) {
                char cur = maps[line].charAt(area);
                if(!visited[line][area] && Character.isDigit(cur)) {
                    int day = searchLand(line, area, height, width, maps);
                    days.add(day);
                }
            }
        }
        
        answer = days.size() == 0 ? new int[]{-1} : days.stream().mapToInt(i -> i).sorted().toArray();
        return answer;
    }
    
    private int searchLand(int line, int area, int height, int width, String[] maps) {
        visited[line][area] = true;
        int result = Integer.parseInt(maps[line].substring(area, area+1));
        
        if(isValid(line-1, area, height, width) && Character.isDigit(maps[line-1].charAt(area))) {
            result += searchLand(line-1, area, height, width, maps);
        }
        
        if(isValid(line+1, area, height, width) && Character.isDigit(maps[line+1].charAt(area))) {
            result += searchLand(line+1, area, height, width, maps);
        }
        
        if(isValid(line, area-1, height, width) && Character.isDigit(maps[line].charAt(area-1))) {
            result += searchLand(line, area-1, height, width, maps);
        }
        
        if(isValid(line, area+1, height, width) && Character.isDigit(maps[line].charAt(area+1))) {
            result += searchLand(line, area+1, height, width, maps);
        }
        
        return result;
    }
    
    private boolean isValid(int line, int area, int height, int width) {
        return line >= 0 && area >= 0 && line < height && area < width && !visited[line][area];
    }
}