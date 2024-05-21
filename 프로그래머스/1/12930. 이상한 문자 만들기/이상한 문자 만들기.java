class Solution {
    public String solution(String s) {
        String answer = "";
		String change= "";

		String[] splitStr = s.split(" ", -1);
		
		for(int i =0; i<splitStr.length;i++) {
			String[] oneChar = splitStr[i].split("");
			
			for(int j=0; j<oneChar.length; j++) {
				
				if(j % 2 == 0) {
					change = oneChar[j].toUpperCase();
				}else {
					change = oneChar[j].toLowerCase();
				}
				answer += change;

			}
			answer += " ";
		}
        answer = answer.substring(0, answer.length()-1);
        return answer;
    }
}