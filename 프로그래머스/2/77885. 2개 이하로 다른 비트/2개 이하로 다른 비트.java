class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            //주어진 수의 이진수의 마지막 2자리가 11이면
            answer[i] = function(numbers[i]);
        }
        return answer;
    }
    
    private long function(long number) {
        return number % 4 == 3 ? 2*function(number/2) + number%2 : number+1;
    }
}