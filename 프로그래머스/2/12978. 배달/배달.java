import java.util.Arrays;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        //1번부터 각 집까지 소요 시간 구하기
        int[][] time = new int[N][N];

        //시간 초기화
        for(int i = 0; i < time.length; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
            time[i][i] = 0;
        }

        for(int[] r : road) {
            time[r[0]-1][r[1]-1] = Math.min(time[r[0]-1][r[1]-1], r[2]);
            time[r[1]-1][r[0]-1] = Math.min(time[r[1]-1][r[0]-1], r[2]);
        }

        // 플로이드-와샬 알고리즘을 사용하여 최단 거리 계산
        /**
         * h i j
         * 0 0 0
         * 0 0 1
         */
        for (int h = 0; h < N; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (time[i][h] != Integer.MAX_VALUE && time[h][j] != Integer.MAX_VALUE) {
                        time[i][j] = Math.min(time[i][j], time[i][h] + time[h][j]);
                    }
                }
            }
        }

        for (int i : time[0]) {
            if(i <= K) answer++;
        }

        return answer;
    }
}
