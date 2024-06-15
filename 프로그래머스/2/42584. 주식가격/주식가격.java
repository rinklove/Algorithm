/*
    효율성을 위해서 참신하게 풀 수 있는 방법을 생각해보자
*/
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            check(answer, prices, i);
        }
        
        return answer;
    }
    
    private void check(int[] answer, int[] prices, int start) {
        for(int j = start+1; j < prices.length; j++) {
            answer[start]++;
            if(prices[start] > prices[j]) {
                break;
            }
        }
    }
}