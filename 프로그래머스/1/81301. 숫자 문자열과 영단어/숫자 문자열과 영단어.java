class Solution {
    public int solution(String s) {
        int answer = 0;
        int i =0;
        String[] numString = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
		try {
			answer = Integer.parseInt(s);
		} catch(Exception e ) {
			for(String str : numString) {
				s= s.replaceAll(str, i+"");
                i++;
			}
			answer = Integer.parseInt(s);
		} 
        return answer;
    }
}