import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    //중복 계산을 피하기 위한 변수
    private static final Map<Long, Long> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());

        long answer = getSum(n,p,q);

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long getSum(long n, long p, long q) {
        if(n == 0) return 1L;

        if(map.containsKey(n)) {
           return map.get(n);
        }

        long value = getSum(n / p, p, q) + getSum(n / q, p, q);
        map.put(n, value);
        return value;
    }
}
