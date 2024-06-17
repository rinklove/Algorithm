import java.io.*;

public class Main {
    static final int DIVIDE = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];

        dp[1][0] = 0;
        for(int i = 1; i < dp[0].length; i++) {
            dp[1][i] = 1;
        }

        for(int d = 2; d < dp.length; d++) {
            dp[d][0] = dp[d-1][1] % DIVIDE;
            for(int i = 1; i <= 8; i++) {
                dp[d][i] = (dp[d-1][i-1] + dp[d-1][i+1]) % DIVIDE;
            }
            dp[d][9] = (dp[d-1][8] % DIVIDE);
        }

        int sum = 0;
        for(int num : dp[n]) {
            sum = (sum + num) % DIVIDE;
        }

        bw.write(""+sum);
        bw.flush();
        br.close();
        bw.close();
    }
}
