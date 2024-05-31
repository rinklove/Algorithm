import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][m+1];


        for(int i = 1; i < map.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //각 우측, 아래에 갔을 경우에 대한 누적되는 사탕 수 설정
        for(int i = 1; i < map[1].length; i++) {
            map[1][i] += map[1][i-1];
        }

        for(int j = 1; j < map.length; j++) {
            map[j][1] += map[j-1][1];
        }

        //각 방향에서 오면서 가장 사탕을 많이 얻는 개수로 갱신
        for(int i = 2; i < map.length; i++) {
            for(int j = 2; j <map[i].length; j++) {
                map[i][j] += Math.max(map[i-1][j], Math.max(map[i-1][j-1], map[i][j-1]));
            }
        }

        bw.write(String.valueOf(map[n][m]));
        bw.flush();
        bw.close();
        br.close();
    }
}
