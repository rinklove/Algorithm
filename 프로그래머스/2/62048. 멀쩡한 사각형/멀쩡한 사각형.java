class Solution {
    public long solution(int w, int h) {
        long answer = (long) w*h;
        int gcd = getGcd(w, h);
        long nonSquare = w + h - gcd;
        return answer - nonSquare; 
    }
    
    private int getGcd(int w, int h) {
        int max = Math.max(w, h);
        int min = Math.min(w, h);
        int gcd = gcd(max, min);
        return gcd;
    }
    
    private int gcd(int bigger, int smaller) {
        if(bigger % smaller == 0) {
            return smaller;
        } else return gcd(smaller, bigger % smaller);
    }
}