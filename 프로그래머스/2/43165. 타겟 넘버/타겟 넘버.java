class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, target, 0);
    }
    
    private int dfs(int[] numbers, int current, int target, int depth) {
        if(depth == numbers.length) {
            if(current == target) {
                return 1;
            } 
            return 0; 
        }
        
        int count = 0;
        count += dfs(numbers, current - numbers[depth], target, depth+1);
        count += dfs(numbers, current + numbers[depth], target, depth+1);
        
        return count;
    }
}