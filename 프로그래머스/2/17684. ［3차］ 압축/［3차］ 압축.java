import java.util.*;

class Solution {
    private final Map<String, Integer> dictionary = new HashMap<>();
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        int next = init();
        int length = msg.length();
        int i = 0;
        while(i < length) {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            while(i < length) {
                sb.append(msg.charAt(i));
                if(dictionary.containsKey(sb.toString())) {
                    index = dictionary.get(sb.toString());
                    i++;
                } else break;
            }
            list.add(index);
            if(sb.length() != 0) {
                dictionary.put(sb.toString(), next++);
            }
        }
        return list.stream().mapToInt(n -> n).toArray();
    }
    
    private int init() {
        int index = 1;
        for(char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(c+"", index++);
        }
        return index;
    }
}