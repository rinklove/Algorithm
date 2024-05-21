import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        String str;
		Arrays.sort(strings);
				
		for(int i =0; i<strings.length; i++) {

			for(int j =i+1; j<strings.length;j++) {			
				
				if(strings[i].charAt(n) > strings[j].charAt(n)) {
					str = strings[j]; 
					strings[j] = strings[i];
					strings[i] = str;
				}				
				if((strings[i].charAt(n) == strings[j].charAt(n)) 
						&& strings[i].compareTo(strings[j])>0)  {
					str = strings[j]; 
					strings[j] = strings[i];
					strings[i] = str;
				}
			}
		}
		answer = strings;
        return answer;
    }
}