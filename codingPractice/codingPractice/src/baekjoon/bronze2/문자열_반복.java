package baekjoon.bronze2;

import java.io.*;
import java.util.Arrays;

public class 문자열_반복 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] per = br.readLine().split(" ");

            int repeat = Integer.parseInt(per[0]);
            String[] split = per[1].split("");
            Arrays.stream(split).forEach(s -> {
                String repeated = s.repeat(repeat);
                try {
                    bw.write(repeated);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            bw.flush();

            if(i != count-1) {
                bw.newLine();
            }
        }

    }
}
