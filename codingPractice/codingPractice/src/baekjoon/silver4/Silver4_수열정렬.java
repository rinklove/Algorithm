package baekjoon.silver4;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Silver4_수열정렬 {

    public static void main(String[] args) throws IOException {

        //수열 P(1) ~ P(N-1)은 1 ~ N-1까지 하나의 수를 포함
        /*
            A[0] = B[P[0]] = 2
            A[1] = B[P[1]] = 1
            A[2] = B[P[2]] = 3
            A[3] = B[P[3]] = 1

            P[0]:2 P[1]:0 P[2]:3 P[3]:1

            B가 오름차순으로 정렬이 되도록하는 인덱스를 추출
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] B = br.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            map.put(i,Integer.parseInt(B[i]));
        }
//        map = {0=2, 1=1, 2=3, 3=1}
//        System.out.println("map = " + map);
//        value로 반환 한 다음에 키 값을 추출.
        List<Integer> list = map.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).thenComparing(Map.Entry<Integer, Integer>::getKey)).map(Map.Entry::getKey).collect(Collectors.toList());

        for(Map.Entry entry : map.entrySet()) {
            int key = (int) entry.getKey();
            bw.write(list.indexOf(key) + " ");
        }
        bw.flush();

    }
}
