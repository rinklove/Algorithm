class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n).trim();
        for(int i =0; i< s.length();i++) {
            answer += (int)s.charAt(i) - 48;
        }
        return answer;
    }
}