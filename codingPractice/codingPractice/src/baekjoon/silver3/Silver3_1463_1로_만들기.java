package baekjoon.silver3;

import java.io.*;

public class Silver3_1463_1로_만들기 {

    /**
     * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
     *
     * X가 3으로 나누어 떨어지면, 3으로 나눈다.
     * X가 2로 나누어 떨어지면, 2로 나눈다.
     * 1을 뺀다.
     *
     * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
     * 연산을 사용하는 횟수의 최솟값을 출력하시오.
     *
     * --
     * 어떤 상황에서 어떤 문자를 써야하지?
     * 1 -> 0
     * 2 -> /2
     * 3 -> /3
     * 4 -> (-1 /3)
     * 5 -> (-1 /2 /2) (-1, -1, /3)
     * 6 -> (/3 , /2)
     * 7 -> (-1 /3 /2)
     * 8 -> (/2 /2 /2)
     * 9 -> (/3 /3)
     * 10 -> (-1 /3 /3 /3)
     * 11 -> (-1 -1 /3 /3 /3)
     * 12 -> (/3 /2 /2)
     * @param args
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(recur(number, 0)));
        bw.flush();
    }

    static int recur(int N, int count) {
        if(N < 2) {
            return count;
        }
        return Math.min(recur(N/2, count+1+(N % 2)), recur(N/3, count + 1 +(N % 3)));
    }
}
