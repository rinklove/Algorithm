import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int aIndex = 0;
        int bIndex = 0;
        int length = A.length;
        
        // 각 팀을 오름차순으로 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        while(aIndex < length && bIndex < length) {
            int playerA = A[aIndex];
            int playerB = B[bIndex];
            
            //만약 B팀이 A팀을 이겼다면 
            //다음 A팀원과 대결하기 위해 A팀 인덱스 증가
            if(playerA < playerB) {
                aIndex++;
                answer++;
            }
            bIndex++;
        }
        return answer;
    }
}