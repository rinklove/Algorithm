package programmers.kakao;

import java.util.HashMap;
import java.util.Map;

public class Level2_뉴스_클러스터링 {

    public static void main(String[] args) {

        int answer = solution("handshake", "shake hands");
        System.out.println("answer = " + answer);
    }

    public static int solution(String str1, String str2) {
        int answer = 0;

        str1 = manufactureStr(str1);
        str2 = manufactureStr(str2);

        //합집합
        //한 원소에 같은 문자가 들어가도 합집합 처리되는 현상이 있는 것 같음.
        Map<String, Integer> union = new HashMap<>();

        putElement(str1, union);
        putElement(str2, union);

        int total = union.keySet().size();
        int intersect = (int) union.entrySet().stream().map(Map.Entry::getValue).filter(i -> i.intValue() == 2).count();
        System.out.println("intersect = " + intersect);
        System.out.println("total = " + total);
        double tmp = (double) intersect / total * 65536 ;
        answer = (int) tmp;
        return answer;
    }

    private static void putElement(String str1, Map<String, Integer> union) {
        for(int i = 0; i < str1.length()-1; i++) {
            String curr = str1.substring(i,i+2);
            union.put(curr, union.getOrDefault(curr, 0)+1);
        }
    }

    public static String manufactureStr(String str) {
        str = str.toLowerCase();
        return str.replaceAll("[^a-z]", "");
    }
}
