import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();

        for (String s : cities) {
            String curr = s.toLowerCase();

            if(cache.contains(curr)) {
                answer++;
                cache.remove(curr);
                cache.add(curr);
            } else {
                answer += 5;
                cache.add(curr);
                if(cache.size() > cacheSize)
                    cache.remove(0);
            }
        }

        return answer;
    }
}