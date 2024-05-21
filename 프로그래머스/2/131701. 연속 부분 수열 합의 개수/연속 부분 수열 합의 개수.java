import java.util.Set;
import java.util.HashSet;

class Solution {
    
    //0 1 2 3 4 / 01 12 23 34 40 / 012 123 234 340 401 / 
    public int solution(int[] elements) {
        int answer = 0;
        
        int size = elements.length;
        Set<Integer> sum = new HashSet<>();
        int count = 1;
        
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                int num = 0;
                for(int k = j; k <= j+i; k++) {
                    num += elements[k % size];
                }
                sum.add(num);
            }
        }
        
        answer = sum.size();
        return answer;
    }
}