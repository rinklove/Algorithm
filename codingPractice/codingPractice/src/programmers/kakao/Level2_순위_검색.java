package programmers.kakao;

import java.util.*;

public class Level2_순위_검색 {

     static Map<String, List<Integer>> map = new HashMap<>();
    /**
     * 문자열 가공이 원하는 대로 잘 안됨
     * -> 조합이 가능한 모든 경우의 수를 파악 후, 유효한 키값만 선별하는 방식
     *
     * (이 말이 맞는 진 모르겠지만..)
     * 모든 경우의 수를 파악 후 해당하는 키값에서만 가져오는 방식이 빠를 때가 있음
     * 이분탐색의 원리 한번 더 파악해보는 것도 괜찮을 듯.
     * @param args
     */
    public static void main(String[] args) {

        int[] solution = solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});

        for (int index : solution) {
            System.out.println("index = " + index);
        }

    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        //모든 조건을 파악
        for (String string : info) {
            dfs(string.split(" "), "", 0);
        }

        //이분 탐색을 위해서 키에 해당하는 값(리스트)을 정렬
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        //조건에 맞는 값만 가져오기
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        return answer;
    }

    //이분 탐색의 원리
    private static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0;
        int end = list.size() - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(list.get(mid) < score) {
                start = mid+1;
            } else {
                end = mid - 1;
            }
        }

        return list.size() - start;
    }

    //가능한 모든 info 조합하기
    private static void dfs(String[] info, String str, int depth) {
        if(depth == 4) {
            int score = Integer.parseInt(info[depth]);

            if(map.containsKey(str)) {
                map.get(str).add(score);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(score);

                map.put(str, list);
            }
            return;
        }
        dfs(info, str+"-", depth+1);
        dfs(info, str+info[depth], depth+1);
    }
}
