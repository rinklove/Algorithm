package baekjoon.silver4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sliveer4_기타줄 {

    /*
        제일 저렴한 줄을 구입하려면?
        패키지 가격과 개별로 6개를 살 때 가격차이가 많이 나
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] lineAndBrand = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();

        for(int i = 0; i < lineAndBrand[1]; i++) {
            //1번째가 6개 가격, 2번째가 개당 가격
            int[] price = Arrays.stream(br.readLine().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();


        }
    }

}
