import java.util.ArrayList;

class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = strArr;
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i =0; i<answer.length; i++) {
			if(answer[i].contains("ad")) continue;
			list.add(answer[i]);
		}

        String[] newArr = new String[list.size()];
		for(int i =0;i<newArr.length;i++) {
            newArr[i] = list.get(i);
        }
        return newArr;
    }
}