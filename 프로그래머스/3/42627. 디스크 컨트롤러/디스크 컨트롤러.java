import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        // 시작 시간을 기준으로 작업을 정렬합니다.
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // 우선순위 큐를 사용하여 작업의 소요 시간을 기준으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int time = 0; // 현재 시간
        int index = 0; // jobs 배열 인덱스
        int totalWaitTime = 0; // 총 대기 시간
        
        // 모든 작업이 처리될 때까지 진행
        while (index < jobs.length || !pq.isEmpty()) {
            // 현재 시간까지 도착한 작업을 큐에 추가
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.offer(jobs[index++]);
            }
            
            if (!pq.isEmpty()) {
                int[] job = pq.poll(); 
                time += job[1]; 
                totalWaitTime += time - job[0]; 
            } else {
                // 처리할 작업이 없다면 시간을 다음 작업의 시작 시간으로 이동합니다.
                time = jobs[index][0];
            }
        }
        
        // 평균 대기 시간을 계산합니다.
        return totalWaitTime / jobs.length;
    }
}
