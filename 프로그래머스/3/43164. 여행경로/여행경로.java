import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        int length = tickets.length;
        String[] answer = {};
        boolean[] used = new boolean[length];
        List<String> seq = new ArrayList<>();
        Arrays.sort(tickets, (a1, a2) -> a1[1].compareTo(a2[1]));
        seq.add("ICN");
        if(search(tickets, used, "ICN", seq, length)) {
            answer = seq.toArray(String[]::new);
        }
        return answer;
    }
    
    private boolean search(String[][] tickets, boolean[] used, String current, List<String> seq, int length) {
        if(seq.size() == length+1) {
            return true;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                seq.add(tickets[i][1]);
                
                if(search(tickets, used, tickets[i][1], seq, length)) {
                    return true;
                }
                
                used[i] = false;
                seq.remove(seq.size() - 1);
            }
        }
        return false;
    }
}