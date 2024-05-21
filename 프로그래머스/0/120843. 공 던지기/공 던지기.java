class Solution {
    public int solution(int[] numbers, int k) {
        
        return numbers[(0+2*(k-1)) % numbers.length];
    }
}