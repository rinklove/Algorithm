import java.util.Arrays;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        Arrays.stream(dic).filter(s-> s.length() == spell.length).toArray();
		boolean isExist = false;
		
		for(int i = 0; i<dic.length; i++) {
			for(int j = 0; j< spell.length; j++) {
				if(dic[i].contains(spell[j]) && dic[i].indexOf(spell[j]) == dic[i].lastIndexOf(spell[j])) {
					isExist = true;
				} else {
					isExist = false;
					break;
				}
			}
			if(isExist) break;
		}
		answer = isExist? 1 : 2;
        return answer;
    }
}