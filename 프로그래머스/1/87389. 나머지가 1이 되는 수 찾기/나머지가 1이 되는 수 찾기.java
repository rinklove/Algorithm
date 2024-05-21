class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1; 
        do {
            if(n % i == 1){
                answer = i;
                break;
            }
            else i++;
        } while (true);
        return answer;
    }
}