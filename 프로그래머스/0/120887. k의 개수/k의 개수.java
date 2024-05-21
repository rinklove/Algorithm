import java.lang.Integer;
class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int a=i;a<=j;a++) {
            int tmp = a;
            while(tmp !=0) {
                if(tmp % 10 == k) {
                    answer++;
                    tmp /= 10;
                } else {
                    tmp /= 10;
                }
            }            
        }
        return answer;
    }
}