package baekjoon.silver4;

import java.io.*;
import java.util.Arrays;

public class Silver4_토너먼트 {

    /*
    4 5
    2 3
    1 2
    -----------------
    1000 35000
    500 17500
    250 8750
    125 4375
    63 2188
    32 1094
    16 547
    8 274
    4 137
    2 69
    1 35
    1 18
    1 9
    1 5
    1 3
    1 2
    두 명의 번호의 차이가 언제 1이 되나?(그냥 1이 아님)
    (left +1) / 2 == right / 2
    1이면 계속 1임
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int round = 1;
        while(arr[0] > 2) {
            if (matched(arr)) break;
            round++;

            arr[1] = (int) Math.ceil((double) arr[1] / 2);
            arr[2] = (int) Math.ceil((double) arr[2] / 2);
            arr[0] = (int) Math.ceil((double) arr[0] / 2);
        }

        if(!matched(arr)) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(round));
        }

        bw.flush();
    }

    private static boolean matched(int[] arr) {
        if(Math.abs((arr[1] / 2) - (arr[2] / 2)) == 1 && Math.abs(arr[2] - arr[1]) == 1) {
            return true;
        }
        return false;
    }
}
