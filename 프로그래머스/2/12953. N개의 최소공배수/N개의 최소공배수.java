class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        for(int i = 1; i < arr.length; i++) {
            arr[0] = (arr[0] * arr[i]) / gcd(arr[0], arr[i]);
        }
        answer = arr[0];
        
        return answer;
    }
    
    private int gcd(int num1, int num2) {
        int number = 0;
        while(num2 != 0) {
            number = num1 % num2;
            num1 = num2;
            num2 = number;
        }
        return num1;
    }
    
    
}