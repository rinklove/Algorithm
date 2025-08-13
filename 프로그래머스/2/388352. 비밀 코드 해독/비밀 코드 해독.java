/*
    조합을 어떻게 할것인가? => dfs?
*/
import java.util.List;
import java.util.ArrayList;

class Solution {
    int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        dfs(new ArrayList<Integer>(), 1, n, q, ans);
        return answer;
    }
    
    private void dfs(
        List<Integer> secretCode, 
        int current, 
        int n, 
        int[][] q, 
        int[] ans
    ) { 
        if(secretCode.size() == 5) {
            checkAnswer(secretCode, q, ans);
            return;
        }
        
        if(current > n) return;
        
        //dfs로직 작성
        secretCode.add(current);
        dfs(secretCode, current+1, n, q, ans);
        secretCode.remove(secretCode.size() - 1);
        dfs(secretCode, current+1, n, q, ans);
    }
    
    private void checkAnswer(List<Integer> secretCode, int[][] q, int[] ans) {
        int tryCount = q.length;
    
        int answerCount = 0;
        for(int i = 0; i < tryCount; i++) {
            if(checkCode(secretCode, q[i]) == ans[i]) {
                answerCount++;
            }
        }
        
        isConform(answerCount, tryCount);
    }
    
    private int checkCode(List<Integer> code, int[] input) {
        int correctCount = 0;
        for(int number : input) {
            if(code.contains(number)) correctCount++;
        }
        
        return correctCount;
    }
    
    private void isConform(int answerCount, int tryCount) {
        if(answerCount == tryCount) {
            answer++;
        }
    }
}