import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static boolean[][] visited;
    static int[][] map;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int answer = Integer.MIN_VALUE;
        setMap(size);

        for (Integer i : set) {
            answer = Math.max(answer, findSafeLand(i));
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int findSafeLand(Integer level) {
        int count = 0;
        visited = new boolean[map.length][map.length];
        for(int row = 0; row < map.length; row++) {
            for(int col = 0; col < map[row].length; col++) {
                if(!visited[row][col] && map[row][col] > level) {
                    count++;
                    dfs(row, col, level);
                }
            }
        }
        return count;
    }

    private static void dfs(int row, int col, int level) {
        visited[row][col] = true;
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for(int d = 0; d < 4; d++) {
            int nextRow = row + dRow[d];
            int nextCol = col + dCol[d];
            if(isSafe(nextRow, nextCol, level)) {
                dfs(nextRow, nextCol, level);
            }
        }
    }

    private static boolean isSafe(int nextRow, int nextCol, int level) {
        return nextRow >= 0 && nextRow < map.length
                && nextCol >= 0 && nextCol < map[0].length
                && !visited[nextRow][nextCol] && map[nextRow][nextCol] > level;
    }

    private static void setMap(int size) throws IOException {
        map = new int[size][size];
        set.add(0);
        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < size; j++) {
               map[i][j] = Integer.parseInt(st.nextToken());
               set.add(map[i][j]);
            }
        }
    }
}
