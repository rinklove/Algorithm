package baekjoon.silver3;

import java.io.*;

public class 이친수 {

    /**
     * 0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다. 이친수는 다음의 성질을 만족한다.
     *
     * 이친수는 0으로 시작하지 않는다.
     * 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
     * 예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.
     *
     * N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.
     * 1-> 1
     * 2 -> 10 (1)
     * 3 -> 101 100 (2)
     * 4 -> 1000 1001 1010 (3)
     * 5 -> 10000 10001 10010 10100 10101 (5)
     * @param args
     */
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());

        if(number < 3) {
            bw.write("1");
        } else  {
            long[] array = new long[number];
            array[0] = 1; //1
            array[1] = 1; //2
            for (int index = 2; index < array.length; index++) {
                array[index] = array[index-1] + array[index-2];
            }
            bw.write(String.valueOf(array[number-1]));
        }

        bw.flush();
    }
}
