/*
    7 - 5
    11 - 6
    15 - 7
*/
class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int number = 1, limit = n*n;
        int count = n-1;
        int next = 0;
        while(number <= limit) {
            int startX = next, startY = next; 
            answer[startX][startY] = number;
            
            if(number == limit) break;
            for(int i = 0; i < count; i++) {
                answer[startX][startY] = number;
                number++;
                startY++;
            }
            
            for(int i = 0; i < count; i++) {
                answer[startX][startY] = number;
                number++;
                startX++;
            }
            for(int i = 0; i < count; i++) {
                answer[startX][startY] = number;
                number++;
                startY--;
            }
            
            for(int i = 0; i < count; i++) {
                answer[startX][startY] = number;
                number++;
                startX--;
            }
            
            count = Math.max(count-2, 1);
            next++;
            System.out.println();
        }
        return answer;
    }
}