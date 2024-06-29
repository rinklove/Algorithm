class Solution {
    public int solution(int[] nums) {
        return findPrime(nums);
    }

    private boolean isPrime(int number) {
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    private int findPrime(int[] nums) {
        int count = 0;
        for(int first = 0; first < nums.length; first++) {
            for(int second = first+1; second < nums.length; second++) {
                for(int third = second+1; third < nums.length; third++) {
                    if(isPrime(nums[first] + nums[second] + nums[third])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}