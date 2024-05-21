class Solution {
    /**
        n = 1 -> 1
        n = 2 -> 2
        n = 3 -> 5
        n = 4 -> ()()()() / (())(()) / ()((())) / ((()))() / 
                 ()()(()) / (())()() / ()(())()  => 7
    */
    public int solution(int n) {
        int answer = 0;
        int[] result = new int[n+1];
        
        //빈 괄호도 정답임.
        result[0] = 1;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                result[i] += result[j] * result[i-j-1];
            }
        }
        for(int i : result) {
            System.out.println(i);
        }
        answer = result[n];
        return answer;
    }
}