import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] S = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideTeams(S, new boolean[n], 0, 0, n);

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void divideTeams(int[][] s, boolean[] visited, int depth, int start, int n) {
        if (depth == n / 2) {
            int startSum = 0, linkSum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        startSum += s[i][j] + s[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        linkSum += s[i][j] + s[j][i];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(startSum - linkSum));
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                divideTeams(s, visited, depth + 1, i + 1, n);
                visited[i] = false;
            }
        }
    }
}
