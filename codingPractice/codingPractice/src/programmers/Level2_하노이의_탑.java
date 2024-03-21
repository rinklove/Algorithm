package programmers;

import java.util.ArrayList;
import java.util.List;

public class Level2_하노이의_탑 {
    public static List<int[]> list;
    public static void main(String[] args) {

        int[][] solution = solution(13);
        for (int[] ints : solution) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int n) {
        int[][] answer = {};

        list = new ArrayList<>();
        dfs(n, 1, 3, 2);
        answer = new int[list.size()][];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void dfs(int n, int start, int to, int mid) {
        if(n == 1) {
            list.add(new int[]{start, to});
            return;
        }
        //n개의 원판 중 n-1개를 2번 기둥에 옮기기
        dfs(n-1, start, mid, to);
        //제일 바닥에 있는 원판을 3번 기둥으로 옮기기
        list.add(new int[]{start, to});

        // 2번 기둥에 있는 나머지 기둥을 3번 기중에 넣기
        dfs(n-1, mid, to, start);
    }
}
