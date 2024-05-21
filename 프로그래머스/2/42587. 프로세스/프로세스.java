class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int length = priorities.length;
        int n = 0;
        
        while(priorities[location] != 0) {
            int index = n++ % length;
            boolean isMax = true;
            
            //현재 자신보다 더 높은 우선순위의 프로세스가 있는 경우
            for(int i = 0; i < length; i++) {
                if(i == index && priorities[i] != 0) continue;
                if(priorities[index] < priorities[i]) {
                    isMax = false;
                    break;
                }
            }
            
            if(isMax) {
                answer++;
                //프로세스 수행 후 종료처리
                priorities[index] = 0;
            }         
        }
        return answer;
    }
}