package baekjoon.silver4;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Silver4_보물 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");

        int[] b = Arrays.stream(B).map(Integer::new).sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
        int[] a = Arrays.stream(A).map(Integer::new).sorted().mapToInt(i -> i).toArray();
        int sum = 0;
        for(int i = 0; i < N; i++) {
            System.out.print("a[i] = " + a[i]);
            System.out.print("b[i] = " + b[i]);
            System.out.println();
            sum = sum + (a[i]*b[i]);
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
