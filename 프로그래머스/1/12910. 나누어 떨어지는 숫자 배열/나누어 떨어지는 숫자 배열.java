import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int index = 0;
        
        for(int i = 0; i <arr.length; i++) {
            if(arr[i] % divisor == 0) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                    answer[index] = arr[i]; 
                index++;
            }
        }
        if(answer.length == 0) {
            answer = Arrays.copyOf(answer, answer.length + 1);
            answer[0] = -1;
        
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}