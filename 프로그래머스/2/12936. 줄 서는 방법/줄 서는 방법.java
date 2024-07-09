import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        // 1부터 n까지 들어있는 리스트 및 n! 값 생성 
        List<Integer> list = getList(n);
        long f = factorial(n);
        
        // 원활한 인덱스 접근을 위해서 k값 감소
        k--;
        for (int i = 0; i < answer.length; i++) {
            // n-1명의 사람을 줄 세우는 경우의 수
            long tmp = f / n;
            // 현재 위치에 올 수 있는 숫자 결정
            answer[i] = list.remove((int) (k / tmp));
            // 다음 위치를 결정하기 위해 k값을 업데이트
            k %= tmp;
            // n-1의 경우로 줄어듦
            f /= n;
            n--;
        }
        
        return answer;  // 최종 답 반환
    }
    
    // 1부터 n까지의 숫자를 리스트로 반환
    private List<Integer> getList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return list;
    }
    
    // n!을 계산하여 반환
    private long factorial(int n) {
        return n == 1 ? 1 : n * factorial(n - 1);
    }
}