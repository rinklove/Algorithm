package baekjoon.bronze2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 알바벳_찾기 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        Map<Character, Integer> alphabetMap = new HashMap<>();

        for(char al = 'a'; al <= 'z'; al++) {
            alphabetMap.put(al, word.indexOf(al));
        }

        int[] arr = alphabetMap.entrySet().stream().mapToInt(Map.Entry::getValue).toArray();
        StringBuilder sb = new StringBuilder();

        for (int a :
                arr) {
            sb.append(a+" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();
    }
}
