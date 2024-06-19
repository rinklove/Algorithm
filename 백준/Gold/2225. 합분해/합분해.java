import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static final int DIV = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[k+1][n+1];

        for(int i = 0; i <dp[1].length; i++) {
            dp[1][i] = 1;
        }

        for (int d = 2; d < dp.length; d++) {
            dp[d][0] = 1;
            for(int i = 1; i < dp[d].length; i++) {
                dp[d][i] = (dp[d-1][i] + dp[d][i-1]) % DIV;
            }
        }

        bw.write(""+dp[k][n]);
        bw.flush();
        bw.close();
        br.close();
    }
}
