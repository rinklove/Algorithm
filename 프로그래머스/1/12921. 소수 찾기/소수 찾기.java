import java.util.Set;
import java.util.HashSet;

class Solution {
    private final Set<Integer> set = new HashSet<>();
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 3; i <= n; i+=2) {
            set.add(i);
        }
        
        for(int i = 3; i <= (int) Math.sqrt(n); i++) {
            for(int j = 2; i*j <= n; j++) {
                set.remove(i*j);           
            }
        }
        return set.size() + 1;
    }
}