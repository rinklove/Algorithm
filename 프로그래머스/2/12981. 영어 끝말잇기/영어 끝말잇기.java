import java.util.ArrayList;
import java.util.List;


class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        List<String> wordLog = new ArrayList<>();
        int round = 1;

        if(words[0].length() < 2) {
           answer[0] = 1;
           answer[1] = round;
           return answer;
        } else {
           wordLog.add(words[0]);
        }

        for (int index = 1; index < words.length; index++) {
            String current = words[index];

            String previous = wordLog.get(index - 1);
            if(!(previous.substring(previous.length()-1).equals(current.substring(0,1))&& wordLog.indexOf(current) <= -1)) {
                answer[0] = (wordLog.size() % n) + 1;
                answer[1] = round + (wordLog.size() / n);
                return answer;
            } else {
                wordLog.add(current);
            }
        }

        return answer;
    }
}