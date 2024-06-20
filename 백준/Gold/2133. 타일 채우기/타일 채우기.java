import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if(n % 2 == 1) {
            bw.write("0");
            bw.flush();
            br.close();
            bw.close();
            return;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[2] = 3;

        for(int i = 4; i < dp.length; i += 2) {
            dp[i] = dp[i-2]*4 - dp[i-4];
        }
        bw.write(""+dp[n]);
        bw.flush();
        bw.close();
        br.close();
    }
}
