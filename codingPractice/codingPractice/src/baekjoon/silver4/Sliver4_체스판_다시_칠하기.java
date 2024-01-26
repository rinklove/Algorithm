package baekjoon.silver4;

import java.io.*;

public class Sliver4_체스판_다시_칠하기 {

    public static void main(String[] args) throws IOException {
        /*
            브루트포스 알고리즘
            BBBBBBBBWBWBW
            BBBBBBBBBWBWB
            BBBBBBBBWBWBW
            BBBBBBBBBWBWB
            BBBBBBBBWBWBW
            BBBBBBBBBWBWB
            BBBBBBBBWBWBW
            BBBBBBBBBWBWB
            WWWWWWWWWWBWB
            WWWWWWWWWWBWB
         */
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] num = br.readLine().split(" ");
        int row = Integer.parseInt(num[0]);
        int col = Integer.parseInt(num[1]);
        char[][] board = new char[row][col];

        //초기 board 생성
        for(int i = 0; i < row; i++) {
            board[i] = br.readLine().toCharArray();
        }


    }
}
