import java.io.*;

public class Main {

    static final int DIVIDE = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];
        for(int i = 0; i < dp[0].length; i++) {
            dp[1][i] = 1;
        }

        for(int d = 2; d < dp.length; d++) {
            dp[d][0] = 1;
            for(int i = 1; i < dp[d].length; i++) {
                dp[d][i] = dp[d-1][i] + dp[d][i-1] % DIVIDE;
            }
        }

        int sum = 0;
        for(int num : dp[n]) {
            sum = (sum + num) % DIVIDE;
        }

        bw.write(""+sum);
        bw.flush();
        bw.close();
        br.close();
    }
}
