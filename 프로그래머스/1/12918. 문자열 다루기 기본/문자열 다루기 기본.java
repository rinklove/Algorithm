class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
		for(char c : arr) {
			if(!(c >= '0' && c <='9') || !(arr.length ==4 || arr.length == 6)) {
				answer = false;
			}
		}
        return answer;
    }
}