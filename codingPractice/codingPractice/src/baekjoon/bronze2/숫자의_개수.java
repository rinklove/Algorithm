package baekjoon.bronze2;

import java.io.*;
import java.util.Arrays;

public class 숫자의_개수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String[] sum = String.valueOf(a * b * c).split("");

        for (int i = 0; i < 10; i++) {
            int current = i;
            int count = (int) Arrays.stream(sum).filter(s -> s.equals(String.valueOf(current))).count();

            bw.write(String.valueOf(count));
            bw.flush();

            if(i != 9) {
                bw.newLine();
            }
        }
    }
}
