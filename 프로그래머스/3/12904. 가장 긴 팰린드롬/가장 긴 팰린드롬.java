/*
    마나커 알고리즘
*/
class Solution {
    public int solution(String s) {
        int answer = 1;
        s = makeString(s);
        
        for(int d = 0; d < s.length(); d++) {
            answer = Math.max(answer, find(s, d));
        }
        return answer;
    }
    
    private int find(String str, int index) {
        int count = 0;
        int d = 1;
        while(index - d >= 0 && index + d < str.length()) {
            if(str.charAt(index-d) == str.charAt(index+d)) {
                count++;
            } else break;
            d++;
        }
        return count;
    }
    
    private String makeString(String str) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++) {
            sb.append("#").append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }
}