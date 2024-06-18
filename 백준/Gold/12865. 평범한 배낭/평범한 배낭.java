import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int weight;
    static int[] weights, values;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = Integer.parseInt(st.nextToken());
        weight = Integer.parseInt(st.nextToken());
        weights = new int[count+1];
        values = new int[count+1];

        for(int i = 1; i <= count; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }
        //배낭에 물건을 담을만한 기준을 선택하지
        /*
            물건이 2개만 있을 때
            담을 수 있는 무게 내에서 가치가 더 큰 것.
            dp
         */
        int[][] dp = new int[count + 1][weight + 1];

        for(int t = 1; t < dp.length; t++) {
            for(int w = 1; w < dp[t].length; w++) { //현재 무게
                if(weights[t] > w) {
                    dp[t][w] = dp[t-1][w];
                } else {
                    //물건을 담을 떄와 담지 않을 때 비교,
                    // 담을 때는 해당 무게가 추가 되기 전의 가치에서 담을 무게의 가치를 합한다.
                    dp[t][w] = Math.max(dp[t-1][w], dp[t-1][w-weights[t]]+values[t]);
                }
            }
        }

        bw.write(""+dp[count][weight]);
        bw.flush();
        br.close();
        bw.close();

    }
}
