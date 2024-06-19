import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int[][] dp = new int[str1.length + 1][str2.length + 1];

        for(int d = 1; d < dp.length; d++) {
            for(int i = 1; i < dp[d].length; i++) {
                if(str1[d-1] == str2[i-1]) {
                    dp[d][i] = dp[d-1][i-1] + 1;
                } else {
                    dp[d][i] = Math.max(dp[d][i-1], dp[d-1][i]);
                }
            }
        }

        bw.write(""+dp[str1.length][str2.length]);
        bw.flush();
        bw.close();
        br.close();
    }
}
