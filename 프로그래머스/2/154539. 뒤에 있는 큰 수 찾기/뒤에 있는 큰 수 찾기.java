import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];
        Arrays.fill(answer, -1);
        int index = length - 1;
        
        while(index >= 0) {
            int dn = 1;
            while(index - dn >= 0 && numbers[index] > numbers[index - dn]) {
                answer[index-dn] = numbers[index];
                dn++;
            }
            index--;
        }
        return answer;
    }
}