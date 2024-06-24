import java.util.*;

class Solution {
    private final List<String> list = new ArrayList<>();
    private final String[] letter = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        int answer = 0;
        
        search("");
        Collections.sort(list);
        return list.indexOf(word) + 1;
    }
    
    private void search(String str) {
        if(str.length() > 5) {
            return;
        }
        if(!str.isEmpty()) {
            list.add(str);    
        }
        for(int i = 0; i < letter.length; i++) {
            search(str + letter[i]);
        }
    }
}