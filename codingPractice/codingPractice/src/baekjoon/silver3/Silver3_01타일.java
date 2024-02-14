package baekjoon.silver3;

import java.io.*;
import java.math.BigInteger;

public class Silver3_01타일 {

    /**
     * N = 0  => 0개(0 0)
     * N = 1 -> 1 -> 1개(0 1)
     * N = 2 -> 00 11 -> 2개
     * N = 3일때? -> 100 001 3개
     * N = 4일때 -> 5개
     * N = 5일때
     * 11111 111A 11A1 1A11 A111 1AA A1A AA1
     * N = 6일때
     * 111111 1111A(5) 11AA
     *---
     * 00(A)과 1로 만들수 있는 2진수의 개수?
     * @param args
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N < 4) {
            bw.write(String.valueOf(N));
        } else {
            int count = 0;
            int n2 = 2;
            int n3 = 3;
            for(int i = 4; i <= N; i++) {
                count = (n2+n3) % 15746;
                n2 = n3;
                n3 = count;
            }
            bw.write(String.valueOf(count));
        }
        bw.flush();
    }
}
