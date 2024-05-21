class Solution {
    public String solution(String s) {
        String answer = "";
        int n = s.length();
		if( (n % 2)  == 1 ) {
            answer = s.subSequence(n/2, n/2+1).toString();
		} else if((n%2) == 0 ) {
            answer = s.subSequence(n/2-1, n/2+1).toString();
		}
        System.out.println(answer);
        return answer;
    }
}