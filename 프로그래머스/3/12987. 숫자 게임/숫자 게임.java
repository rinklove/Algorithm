import java.util.Arrays;
class Solution {
    /*
        1 3 5 7
        2 2 6 8
        10만번이면 사실상 dfs, bfs는 불가능한 방법인거 같은데...
        
    */
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int aIndex = 0;
        int bIndex = 0;
        int length = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        while(aIndex < length && bIndex < length) {
            int playerA = A[aIndex];
            int playerB = B[bIndex];
            
            if(playerA < playerB) {
                aIndex++;
                answer++;
            }
            bIndex++;
            
        }
        
        return answer;
    }
}