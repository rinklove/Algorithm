import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        
        String[] strArray = Long.toString(n).split("");
        Arrays.sort(strArray, Collections.reverseOrder());
        
        String str = "";
        
        for(String s : strArray) {
            str += s;
        }
        
        return Long.parseLong(str);
    }
}