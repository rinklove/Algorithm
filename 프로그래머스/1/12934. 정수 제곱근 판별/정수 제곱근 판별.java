class Solution {
    public long solution(long n) {
        long answer = 0;
        
        long i = (long)Math.sqrt(n);
        if (i*i == n) {
            i++;
            return i*i;
        } else return -1;
    }
}