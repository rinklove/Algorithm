import java.util.Set;
import java.util.HashSet;

class Solution {
    /* 
        탐험할 수 있는 최대 던전 수
        시도할 수 있는 모든 탐색방법을 파악
        -> 해당 순서대로 던전 탐색?
    */
    private final Set<String> sequences = new HashSet<>();
    public int solution(int k, int[][] dungeons) {
        int answer = Integer.MIN_VALUE;
        int current = k;
        int length = dungeons.length;
        
        //각 던전의 인덱스를 문자열로 생성
        String str = findAllIndexes(length);
        
        //던전을 모두 탐색할 수 있는 모든 순서 저장 
        setSequences(str, "", length);

        
        for(String seq : sequences) {
            //던전 탐색
            int count = search(seq.split(""), current, dungeons);
            
            //기존에 탐색 방법보다 더 많이 탐색한 경우 answer값 갱신
            if(answer < count) {
                answer = count;
            }
        }
        
        return answer;
    }
    
    private String findAllIndexes(int length) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < length; i++) {
            sb.append(i);
        }
        
        return sb.toString();
    }
    
    //모든 던전을 도는 순서 저장
    private void setSequences(String others, String sequence, int length) {
        //모든 던전을 다 탐색한 경우 set에 경로 저장 후 종료
        if(sequence.length() == length) {
            sequences.add(sequence);
            return;
        }
        
        for(int i = 0; i < others.length(); i++) {
            String newOthers = others.substring(0, i)+others.substring(i+1);
            String newSequence = sequence+others.charAt(i);
            setSequences(newOthers, newSequence, length);
        }
    }
    
    private int search(String[] seq, int k, int[][] dungeons) {
        int count = 0;
        
        for(int i = 0; i < seq.length; i++) {
            int current = Integer.parseInt(seq[i]);
            
            if(k >= dungeons[current][0]) {
                k -= dungeons[current][1];
                count++;
            }
        }
        return count;
    }
}