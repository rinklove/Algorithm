/**
    행렬의 곱셈
    1 4     3 3
    3 2     3 3
    4 1 
    
    2 3 2   5 4 3
    4 2 4   2 4 1
    3 1 4   3 1 1
*/
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i = 0; i < answer.length; i++) {
            for(int j = 0; j < answer[i].length; j++) {
                answer[i][j] = getResult(arr1, arr2, i, j);
            }
        }
        return answer;
    }
    
    
    private int getResult(int[][] arr1, int[][] arr2, int n1, int n2) {
        int result = 0;
        
        for(int i = 0; i < arr2.length; i++) {
            result += (arr1[n1][i] * arr2[i][n2]);
        }
        
        return result;
    }
}