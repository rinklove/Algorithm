package baekjoon.bronze1;

import java.io.*;
import java.math.BigInteger;

public class 피보나치수_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        if(num < 2) {
            bw.write(String.valueOf(num));
        } else {
            BigInteger n0 = BigInteger.ZERO;
            BigInteger n1 = BigInteger.ONE;
            BigInteger sum = BigInteger.ZERO;
            for (int i = 2; i <= num ; i++) {
               sum = n0.add(n1);
               n0 = n1;
               n1 = sum;
            }

            bw.write(sum.toString());
        }
        bw.flush();
    }
}
