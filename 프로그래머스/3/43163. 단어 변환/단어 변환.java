import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    /**
        탐색의 우선 순위
        hit > cog
        hit -> (cit / hot(V) / hig) -> ...
        bfs로 탐색?
    */
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean isExist = false;
        
        //words안에 target이 존재하는 지 검사
        for(String w : words) {
            if(w.equals(target)) {
                isExist = true;
                break;
            }
        }
        
        if(!isExist) return 0;
                
        //bfs로 횟수 탐색하기
        answer = bfs(begin, target, words);
        
        return answer;
    }
    
    private boolean compareWord(String word, String target) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
    
    private int bfs(String begin, String target, String[] words) {
        
        Queue<String> queue = new LinkedList<>();
        
        //변환한 단어 내역을 담는 변수
        Set<String> log = new HashSet<>();
        
        int level = 0;
        queue.add(begin);
        log.add(begin);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) return level;

                for (String word : words) {
                    if (!log.contains(word) && compareWord(current, word)) {
                        queue.offer(word);
                        log.add(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}