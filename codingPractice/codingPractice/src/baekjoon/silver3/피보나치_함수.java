package baekjoon.silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 피보나치_함수 {

    /**
     * fibonacci(N)을 호출했을 때,
     * 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
     * ----
     * 0 1 1 2 3 5
     * 1 -> 1
     * 2 -> 0 1
     * 3 -> 0 1 1
     * 4:-> 1 0 1 1 0
     * 5 -> 1 0 1 1 0 1 0 1
     * => fibo(N)에서 fibo(1)의 개수는 fibo(N)개,
     * fibo(0)의 개수는 fibo(N-1)개
     * @param args
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        fibonacci.add(1);

        for (int i = 0; i < count; i++) {
            int N = Integer.parseInt(br.readLine());

            switch (N) {
                case 0: bw.write("1 0"); break;
                case 1: bw.write("0 1"); break;
                default:
                    while(N >= fibonacci.size()) {
                        fibonacci.add(fibonacci.get(fibonacci.size()-2)+fibonacci.get(fibonacci.size()-1));
                    }


                    bw.write(fibonacci.get(N-1)+" "+fibonacci.get(N));
                    break;
            }
            if(i != count-1) {
                bw.newLine();
            }
        }

        bw.flush();
    }
}
