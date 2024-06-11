import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] numbers, print;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        numbers = new int[n];
        print = new int[m];
        visited = new boolean[n];

        br.close();
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        search(0);
    }

    private static void search(int depth) {
        if(depth == m) {
            for (int p : print) {
                System.out.print(p + " ");
            }
            System.out.println();
           return;
        }

        int before = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(visited[i]) continue;

            if(before != numbers[i]) {
                visited[i] = true;
                print[depth] = numbers[i];
                before = numbers[i];
                search(depth+1);
                //백트래킹을 위해서 방문 표시 해제
                visited[i] = false;
            }
        }
    }
}
