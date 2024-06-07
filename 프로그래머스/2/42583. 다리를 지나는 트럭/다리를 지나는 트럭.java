import java.util.*;

class Solution {
    //트럭 무게, 시간
    private final Queue<int[]> bridge = new LinkedList<>();
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; //전체 시간
        int currentWeight = 0;  //현재 다리의 무게
        int index = 0;  //대기하는 트럭 중 다리를 건너려는 트럭
        
        //모든 트럭이 다리를 건널 때 까지
        while(index < truck_weights.length || !bridge.isEmpty()) {
            answer++;
            //가장 앞에 있는 트럭이 다 건넜다면,
            if(!bridge.isEmpty() && bridge.peek()[1] == bridge_length) {
                currentWeight -= bridge.poll()[0];
            }
            
            //다음 트럭이 다리를 건널 수 있다면,
            if(index < truck_weights.length && currentWeight + truck_weights[index] <= weight) {
                currentWeight += truck_weights[index];
                bridge.offer(new int[]{truck_weights[index++], 0});
            }
            
            //다리 위에 있는 트럭들의 시간 증가
            for(int[] t : bridge) {
                t[1]++;
            }
        }
        return answer;
    }
}