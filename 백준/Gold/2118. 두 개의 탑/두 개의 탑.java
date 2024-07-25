import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] distances = new int[n];
        int[] prefix = new int[n+1];
        int total = 0;
        int answer = -1;

        for(int d = 0; d < n; d++) {
            int distance = Integer.parseInt(br.readLine());
            distances[d] = distance;
            total += distance;
        }

        for(int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + distances[i];
        }
        //0, 1, 3, 6 ,10, 15
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                int distance1 = prefix[i] - prefix[j];
                int distance2 = total - distance1;
                answer = Math.max(answer, Math.min(distance1, distance2));
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
