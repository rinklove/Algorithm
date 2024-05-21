class Solution {
    public int solution(int a, int b) {
       int answer = 0;
	    int number = gcd(Math.min(a,b), Math.max(a, b));
		a /= number;
		b /= number;
		
		while(b != 1) {
			if(b % 2 == 0) b/= 2;
			else if(b % 5 == 0) b/= 5;
			else break;
		}
		answer = b == 1? 1 : 2;
        return answer;
    }
    
    public int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a% b);
	}
}