import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String[] solution(String my_string) {
        String[] answer;
		
		List<String> list = Arrays.asList(my_string.trim().split(" ", -1));
		List<String> newList = new ArrayList();
		 
		for(int i =0; i< list.size(); i++) {
			if(!list.get(i).equals("")) {
				newList.add(list.get(i));
			}
		}
		
		answer = new String[newList.size()]; 
		newList.toArray(answer);
        return answer;
    }
}