package baekjoon.silver4;

import java.io.*;
import java.util.Arrays;

public class Silver4_좋은_구간 {

    /**
     * 1 7 14 10
     * 2
     * 2 3
     * 2 4
     * 2 5
     * 2 6
     * 20
     *  => 16
     * -----
     * 8 13
     * 10
     * 9 10
     * 9 11
     * 9 12
     * 10 11
     * 10 12
     * 9  / 11 12
     * ------
     * 33 100
     * 59
     * 34  ~ 58 / 59 / 60 ~ 99
     * 25개 + 39개 + 39*25개
     * -> n보다 작은 수는?
     * -> n보다 큰 수는 한 가지 경우의 수만 가능
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int num = Integer.parseInt(br.readLine());

        int include = (int) Arrays.stream(arr).filter(i -> i == num).count();

        if(include != 0) {
            bw.write("0");
        } else {
            int sectorMin = Arrays.stream(arr).filter(i -> i < num).max().orElse(0);
            int sectorMax = Arrays.stream(arr).filter(i -> i > num).min().orElse(1000);

            int goodSectorMin = num - sectorMin - 1;
            int goodSectorMax = sectorMax - num - 1;

            int count = goodSectorMin + goodSectorMax + goodSectorMin * goodSectorMax;
            bw.write(String.valueOf(count));
        }

        bw.flush();
    }
}
