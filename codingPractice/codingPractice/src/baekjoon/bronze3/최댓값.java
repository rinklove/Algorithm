package baekjoon.bronze3;

import java.io.*;
import java.util.Arrays;

public class 최댓값 {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[9];

        for(int index = 0; index < 9; index++) {
            arr[index] = Integer.parseInt(br.readLine());
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int index = 0;
        for (int i = 0; i < 9; i++) {
            if(arr[i] == max) {
                index = i+1;
                break;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.newLine();
        bw.write(String.valueOf(index));
        bw.flush();
    }
}
