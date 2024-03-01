package baekjoon.silver3;

import java.io.*;

public class 수_이어_쓰기 {

    /**
     * 세준이는 1부터 N까지 모든 수를 차례대로 공백없이 한 줄에 다 썼다. 그리고 나서, 세준이가 저녁을 먹으러 나간 사이에 다솜이는 세준이가 쓴 수에서 마음에 드는 몇 개의 숫자를 지웠다.
     *
     * 세준이는 저녁을 먹으러 갔다 와서, 자기가 쓴 수의 일부가 지워져있는 모습을 보고 충격받았다.
     *
     * 세준이는 수를 방금 전과 똑같이 쓰려고 한다. 하지만, N이 기억이 나지 않는다.
     *
     * 남은 수를 이어 붙인 수가 주어질 때, N의 최솟값을 구하는 프로그램을 작성하시오. 아무것도 지우지 않을 수도 있다.)
     * @param args
     * ----
     * 111111 테스트 케이스 실패중
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split("");

        int min = Integer.parseInt(arr[0]);
        int firstNum = 0;
        int lastNum = min;
        for(int index = 1; index < arr.length; index++) {
            int curr = Integer.parseInt(arr[index]);


        }

        bw.write(String.valueOf(min));
        bw.flush();
    }
}
