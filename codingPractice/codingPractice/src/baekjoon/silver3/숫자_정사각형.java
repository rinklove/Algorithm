package baekjoon.silver3;

import java.io.*;
import java.util.StringTokenizer;

public class 숫자_정사각형 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        //직사각형 정의
        String[] square = new String[height];
        for(int index = 0; index < height; index++) {
            square[index] = br.readLine();
        }

        //높이와 넓이 중 짧은 길이부터 정사각형이 존재하므로
        int min = Math.min(height, width);

        //한 변의 길이가 min부터 2까지인 정사작형이 존재하는 지 찾기
        while(min > 1) {
            for (int i = 0; i <= height-min; i++) {
                for(int j = 0; j <= width-min; j++) {
                    String dot1 = square[i].substring(j, j+1);
                    String dot2 = square[i].substring(j+min-1, j+min);
                    String dot3 = square[i+min-1].substring(j, j+1);
                    String dot4 = square[i+min-1].substring(j+min-1, j+min);

                    //각 변의 길이가 같으면
                    if(dot1.equals(dot2) && dot2.equals(dot3) && dot3.equals(dot4) && dot4.equals(dot1)) {
                        bw.write(String.valueOf(min*min));
                        bw.flush();
                        return;
                    }
                }
            }

            min--;
        }

        //없으면 길이가 1인 정사각형만 존재하므로 넓이가 1임.
        bw.write("1");
        bw.flush();
    }
}
