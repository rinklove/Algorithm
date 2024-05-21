import java.util.*;

class Solution {
    
    private Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
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
    
    private int binarySearch(String key, int score) {
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
    private void dfs(String[] info, String str, int depth) {
        // System.out.println("str = " + str);
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