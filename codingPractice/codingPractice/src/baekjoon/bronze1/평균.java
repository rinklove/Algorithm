package baekjoon.bronze1;

import java.io.*;
import java.util.Arrays;

public class 평균 {

    /**
     * 세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다.
     * 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다.
     * 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
     *
     * 예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
     *
     * 세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
     *
     * -> 만약 모든 값이 최대값이 2개 이상이면?
     * -> 모든 점수를 바꿔야 함!
     * 301 / 4
     * @param args
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = Arrays.stream(scores).max().getAsInt();

        double avarage = Arrays.stream(scores).mapToDouble(i ->
                ((double) i / max) * 100
        ).average().getAsDouble();

        bw.write(String.valueOf(avarage));
        bw.flush();
    }
}
