import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited, farm;
    static BufferedReader br;
    static BufferedWriter bw;
    static int count;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스의 수 입력
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 각 테스트 케이스마다 처리
        for (int t = 0; t < testCase; t++) {
            count = 0;
            st = new StringTokenizer(br.readLine(), " ");
            setFarm(st);
            countComponents();
            bw.write(String.valueOf(count));
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    // 농장의 연결된 부분(컴포넌트)의 수를 계산
    private static void countComponents() {
        for (int i = 0; i < farm.length; i++) {
            for (int j = 0; j < farm[i].length; j++) {
                if (farm[i][j] && !visited[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }
    }

    // 깊이 우선 탐색(DFS)으로 연결된 부분 탐색
    private static void dfs(int i, int j) {
        visited[i][j] = true;
        if (isValid(i, j - 1)) dfs(i, j - 1);
        if (isValid(i, j + 1)) dfs(i, j + 1);
        if (isValid(i - 1, j)) dfs(i - 1, j);
        if (isValid(i + 1, j)) dfs(i + 1, j);
    }

    // 유효한 좌표인지 확인
    private static boolean isValid(int i, int j) {
        return i >= 0 && i < farm.length && j >= 0 && j < farm[0].length && !visited[i][j] && farm[i][j];
    }

    // 농장 설정
    private static void setFarm(StringTokenizer st) throws IOException {
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        farm = new boolean[height][width];
        visited = new boolean[height][width];
        int count = Integer.parseInt(st.nextToken());

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            farm[c2][c1] = true;
        }
    }
}
