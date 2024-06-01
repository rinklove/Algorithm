import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        short n = Short.parseShort(st.nextToken());
        short start = Short.parseShort(st.nextToken());
        short limit = Short.parseShort(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] volumes = new int[n];

        for (int i = 0; i < volumes.length; i++) {
            volumes[i] = Short.parseShort(st.nextToken());
        }

        bw.write(findMax(start, limit, volumes)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int findMax(int start, int limit, int[] volumes) {
        boolean[][] dp = new boolean[volumes.length + 1][limit + 1];
        dp[0][start] = true;

        for (int i = 0; i < volumes.length; i++) {
            for (int j = 0; j <= limit; j++) {
                if (dp[i][j]) {
                    if (j + volumes[i] <= limit) {
                        dp[i + 1][j + volumes[i]] = true;
                    }
                    if (j - volumes[i] >= 0) {
                        dp[i + 1][j - volumes[i]] = true;
                    }
                }
            }
        }

        for (int j = limit; j >= 0; j--) {
            if (dp[volumes.length][j]) {
                return j;
            }
        }

        return -1;  // 가능한 볼륨이 없을 경우 -1 반환
    }
}
