class Solution {
    private int[][] procession;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];        
        
        init(rows, columns);    //배열 초기화
        int index = 0;
        for(int[] query :queries) {
            answer[index++] = rotateAndGetMin(query);
        }
        
        return answer;
    }
    
    private void init(int row, int column) {
        procession = new int[row][column];
        int number = 1;
        for(int[] line : procession) {
            for(int i = 0; i < line.length; i++) {
                line[i] = number++;
            }
        }
    }
    
    private int rotateAndGetMin(int[] query) {
        //2 2 5 4 -> 1 1 4 3
        minus1(query);
        
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];
        
        int tmp = procession[x1][y1];
        int min = tmp;
        
        //왼쪽
        for(int i = x1; i < x2; i++) {
            procession[i][y1] = procession[i+1][y1];
            min = Math.min(min, procession[i][y1]);
        }
        
        //아래
        for(int i = y1; i < y2; i++) {
            procession[x2][i] = procession[x2][i+1];
            min = Math.min(min, procession[x2][i]);
        }
        
        //오른쪽
        for(int i = x2; i > x1 ; i--) {
            procession[i][y2] = procession[i-1][y2];
            min = Math.min(min, procession[i][y2]);
        }
        
        //위
        for(int i = y2; i > y1 ; i--) {
            procession[x1][i] = procession[x1][i-1];
            min = Math.min(min, procession[x1][i]);
        }
        
        procession[x1][y1+1] = tmp;
        return min;
    }
    
    
    private void minus1(int[] query) {
        for(int i = 0; i < query.length; i++) {
            query[i]--;
        }
    }
}