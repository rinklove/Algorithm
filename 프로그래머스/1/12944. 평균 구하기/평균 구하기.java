class Solution {
    public static double solution(int[] arr) {
        double answer = 0;
        for(int i=0; i<arr.length; i++) {
            answer += arr[i];
        }
        answer /= arr.length;
        return answer;
    }
    
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(solution(array));
    }
}