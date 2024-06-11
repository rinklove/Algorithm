import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, sum, count = 0;
    static int[] element;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        sum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        element = new int[n];
        for(int i = 0; i < element.length; i++) {
            element[i] = Integer.parseInt(st.nextToken());
        }

        search(0, 0);
        if(sum == 0) count--;
        bw.write(""+count);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void search(int current, int depth) {
        if(depth == element.length) {
            if(current == sum)
                count++;
            return;
        }

        search(current + element[depth], depth+1);
        search(current, depth+1);
    }
}
