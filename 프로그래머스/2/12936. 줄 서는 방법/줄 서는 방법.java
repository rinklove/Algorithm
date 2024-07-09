/*
    1 = 1
    2 = 2
    3 = 6
*/
import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = getList(n);
        long f = factorial(n);
        
        k--;
        for(int i = 0; i < answer.length; i++) {
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