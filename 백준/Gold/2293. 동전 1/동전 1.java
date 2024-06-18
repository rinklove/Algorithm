import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k+1];
        dp[0] = 1;

        int[] coins = new int[n];
        for(int c = 0; c < coins.length; c++) {
            coins[c] = Integer.parseInt(br.readLine());
        }

        for(int c = 0; c < n; c++) {
            for (int i = coins[c]; i < dp.length; i++) {
                dp[i] += dp[i-coins[c]];
            }
        }

        bw.write("" + dp[k]);
        bw.flush();
        br.close();
        bw.close();
    }
}
