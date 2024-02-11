package baekjoon.silver3;

import java.io.*;
import java.util.Arrays;

public class 터렛 {


    /**
     * 류재명의 위치 x, y
     * (x-a)^2 + (y-b)^2 - r1^2 = (x-c)^2 + (x-d)^2 - r2^2
     * x(a+c+2)(a-c)+y(b+d-2)(b-d) -24 = 0
     * x(40)(-40)+y(0-2)(0) - 231  = 0
     * -160x -2y = 231
     *-----------
     * 위치의 개수가 무한대인 경우 ? -> 위치가 같은 경우?
     *(2개, 1개, 0개, 일치) 타원이 아닌이상 3개는 불가능
     *
     * 1개만 겹치는 경우 접할 때,
     * ------------
     * 조규현 위치, 백승환의 위치, 그리고 류재명의 위치로 삼각형을 그려본다면?
     * --> 원과 삼각형
     * @param args
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());

        for(int t = 0; t < testcase; t++) {
            double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(i -> Double.parseDouble(i)).toArray();

            double distancePow = Math.pow(arr[3]-arr[0], 2) + Math.pow(arr[4]-arr[1], 2);

            //두 원이 일치할 떄
            if(arr[0]==arr[3] && arr[1] == arr[4] && arr[2] == arr[5]) {
                bw.write("-1");
                //한 원이 다른 원 안에 있지만 접하지 않을 떄, 반지름 길이 합보다 더 멀리 있을 때
            } else if (distancePow < Math.pow(arr[5] - arr[2], 2) || distancePow > Math.pow(arr[5]+arr[2], 2)) {
                bw.write("0");
                //내접 또는 외접할 때
            } else if (distancePow == Math.pow(arr[5]-arr[2], 2) || distancePow == Math.pow(arr[5]+arr[2], 2)) {
                bw.write("1");
            } else {
                bw.write("2");
            }

            if(t != testcase-1) {
                bw.newLine();
            }
        }

        bw.flush();
    }


}
