class Solution {
    public int[] solution(String s) {
        
        int[] answer = new int[2];
        
		while(true) {
			int before = s.length();
			s = s.replaceAll("0", "");
			int after = s.length();
			
			answer[1] += (before - after);
			
			s = Integer.toBinaryString(s.length());
			answer[0]++;
            
			if(s.equals("1")) break;
		}
        return answer;
    }
}