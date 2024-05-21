class Solution {
    public int solution(int num) {
        long answer = num;
        int count = 0;
        
        while (answer != 1) {
            if(answer % 2 == 0) {
                answer = answer / 2;
            } else {
                answer = answer * 3 + 1;
            }
            count++;
            if(count == 500) {
                count = -1;
                break;
            }
        }
        
        return count;
    }
}