package baekjoon.silver4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sliveer4_기타줄 {

    /*
        제일 저렴한 줄을 구입하려면?
        1. 먼저 줄 개수를 구하자(10개를 1묶음 4개 형식으로)
        2. 그리고 묶음 단위와 낱개 6개로 사는 금액을비교
        3. 묶음 단위와 나머지 단위로 사는 금액 비교
        4. 기존의 금액보다 저렴하면 확정
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] lineAndBrand = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();

        int bundle = lineAndBrand[0] / 6;
        int per = lineAndBrand[0] % 6 ;

        int minBundle = Integer.MAX_VALUE;
        int minPer = Integer.MAX_VALUE;

        for(int i = 0; i < lineAndBrand[1]; i++) {
            int currentBundle = 0;
            int currentPer = 0;
            //1번째가 6개 가격, 2번째가 개당 가격
            int[] price = Arrays.stream(br.readLine().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();
            


            currentBundle = comparePrice(price, 6);
            if(currentBundle < minBundle) minBundle = currentBundle;

            currentPer = comparePrice(price,per);
            if(currentPer < minPer) minPer = currentPer;

        }

        bw.write(String.valueOf(minBundle*bundle + minPer));
        bw.flush();
    }

    private static int comparePrice(int[] price, int count) {
        return Math.min(price[0], price[1]*count);
    }

}
