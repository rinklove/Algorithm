package baekjoon.silver4;

import java.io.*;
import java.util.Arrays;

public class Sliver4_체스판_다시_칠하기 {

    public static void main(String[] args) throws IOException {
        /*
            브루트포스 알고리즘
            BBBBB BBBWBWBW
            BBBBB BBBBWBWB
            BBBBB BBBWBWBW
            BBBBB BBBBWBWB
            BBBBB BBBWBWBW
            BBBBB BBBBWBWB
            BBBBB BBBWBWBW
            BBBBB BBBBWBWB
            WWWWWWWWWWBWB
            WWWWWWWWWWBWB
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] num = br.readLine().split(" ");
        int row = Integer.parseInt(num[0]);
        int col = Integer.parseInt(num[1]);
        String[] board = new String[row];

        //초기 board 생성
        for(int i = 0; i < row; i++) {
            board[i] = br.readLine();
        }

        int answer = Integer.MAX_VALUE;

        for(int yIndex = 0; yIndex < row-7; yIndex++) {
            String[] tmp = Arrays.copyOfRange(board, yIndex, yIndex+8);
            for(int xIndex = 0; xIndex < col-7; xIndex++) {
                int current = xIndex;
                String[] chessBoard = Arrays.stream(tmp).map(e -> e.substring(current, current + 8)).toArray(String[]::new);

                int count = checkToPaint(chessBoard);
                System.out.println("count = " + count);
                if(answer > count) answer = count;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();

    }

    /**
     * 체스판 몇 개 칠해야 하는지?
     * @param chessBoard
     * @return
     */
    private static int checkToPaint(String[] chessBoard) {
        int startW = 0;
        int startB = 0;
        String[] chessLine = {"BWBWBWBW", "WBWBWBWB"};

        for(int i = 0; i < 8; i++) {
            String current = chessBoard[i];
            if(i % 2  == 0) {
                for(int j = 0; j < 8; j++) {
                    if(!current.substring(j, j+1).equals(chessLine[1].substring(j,j+1))) {
                        startW++;
                    }
                }
            } else {
                for(int j = 0; j < 8; j++) {
                    if(!current.substring(j, j+1).equals(chessLine[0].substring(j,j+1))) {
                        startW++;
                    }
                }
            }
        }

        for(int i = 0; i < 8; i++) {
            String current = chessBoard[i];
            if(i % 2  == 0) {
                for(int j = 0; j < 8; j++) {
                    if(!current.substring(j, j+1).equals(chessLine[0].substring(j,j+1))) {
                        startB++;
                    }
                }
            } else {
                for(int j = 0; j < 8; j++) {
                    if(!current.substring(j, j+1).equals(chessLine[1].substring(j,j+1))) {
                        startB++;
                    }
                }
            }
        }

        return Math.min(startB, startW);
    }
}
