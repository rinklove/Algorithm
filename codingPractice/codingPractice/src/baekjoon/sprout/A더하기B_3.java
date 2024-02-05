package baekjoon.sprout;

import java.io.*;

public class A더하기B_3 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++) {
            String[] num = br.readLine().split(" ");

            int sum = Integer.parseInt(num[0]) + Integer.parseInt(num[1]);
            bw.write(String.valueOf(sum));
            bw.flush();

            if(i != n-1) {
                bw.newLine();
            }
        }
    }
}
