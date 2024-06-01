
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        //가독성을 위해 받은 값에서 +1해서 배열 생성
        int[][] dp = new int[n+1][3];
        int[][] costs = new int[n+1][3];

        for(int i = 1; i < costs.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        //첫 번째 집을 RGB로 각각 칠했을 때 비용
        dp[1][0] = costs[1][0];
        dp[1][1] = costs[1][1];
        dp[1][2] = costs[1][2];

        //현재 집을 칠했을 때의 비용 + (이전 집에서 현재 집이랑 다른 색깔로 칠했을 때 비용의 합 중 가장 작은 것으로)
        for(int i = 2; i < dp.length; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        //마지막 집까지 칠했을 때 비용이 가장 작은 값 반환
        int min = Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }
}