import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] charArr = dartResult.toCharArray();
		int[] score  = {0,0,0};
		int index = 0;
		String s = "";
		for(int i  = 0; i < charArr.length; i++) {
			if(Character.isDigit(charArr[i])) {
				s += charArr[i]+ "";
			} else {
				if(!s.isEmpty()) {
					score[index] = Integer.parseInt(s);
					s="";
					index++;		
				}
				switch(charArr[i]) {
					case 'S': break;
					case 'D': score[index-1] = (int) Math.pow(score[index-1], 2); break;
					case 'T': score[index-1] = (int) Math.pow(score[index-1], 3); break;
					case '*': if(index > 1) {
						score[index-1] *= 2; 
						score[index-2] *= 2; 						
					} else {
						score[index] *= 2; 
						score[index-1] *= 2; 	
					} break; 
					case '#': score[index-1] *= (-1); break;
					default: break;
				}
			}
		}
        answer = Arrays.stream(score).sum();
        return answer;
    }
}