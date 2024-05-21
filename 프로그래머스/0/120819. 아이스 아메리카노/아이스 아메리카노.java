class Solution {
    public static int[] solution(int money) {
        int[] answer = {0,0};
        
        answer[0] = money / 5500;
        answer[1] = money % 5500;
        return answer;
    }
    
    public static void main(String[] args) {
        int[] arr = solution(10000);
        System.out.println(arr[0] +", " +arr[1]);
    }
}