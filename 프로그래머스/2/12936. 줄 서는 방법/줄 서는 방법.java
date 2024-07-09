import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        //1부터 n까지 들어있는 리스트 및 n! 값 생성 
        List<Integer> list = getList(n);
        long f = factorial(n);
        
        //원활한 인덱스 접근을 위해서 k값 감소
        k--;
        for(int i = 0; i < answer.length; i++) {
            //n-1명의 사람을 줄세우는 경우의 수
            long tmp = f / n;
            answer[i] =  list.remove((int) (k / tmp));
            k %= tmp;
            f /= n;
            n--;
        }
        
        return answer;
    }
    
    private List<Integer> getList(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        return list;
    }
    
    private long factorial(int n) {
        return n == 1 ? 1 : n * factorial(n-1);
    }
}