import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    /**
        무슨 자료구조를 사용해야 할까? 
        -> 메뉴 조합도 고려해야하고, 주문한 횟수도 고려해야 하니 HashMap이 가장 나을려나?

        그럼 메뉴 조합은 어떻게 해야할까? - 백트래킹  
    */
    private final Map<String, Integer> count = new HashMap<>(); 
    public String[] solution(String[] orders, int[] course) {
        //각 손님이 주문한 메뉴들의 모든 조합을 구하기
        setCounts(orders);
        
        //개수별로 가장 많이 주문한 조합 리스트를 가져오기
        List<String> list = new ArrayList<>();
        for(int c : course) {
            getCourses(c, list);
        }
        
        //리스트 사전순으로 정렬
        String[] answer = list.toArray(String[]::new);
        Arrays.sort(answer);
        return answer;
    }
    
    private void getCourses(int c, List<String> list) {
        String[] menus = count.entrySet().stream()
            .filter(e -> e.getKey().length() == c && e.getValue() == getMax(c)).map(Map.Entry::getKey)
            .toArray(String[]::new);
        
        for(String m : menus) {
            list.add(m);
        }
    }
    
    private int getMax(int length) {
        int[] arr = count.entrySet().stream()
            .filter(e -> e.getKey().length() == length)
            .mapToInt(Map.Entry::getValue).toArray();
        
        int max = 2;
        for(int a : arr) {
            max = Math.max(a, max); 
        }
        return max;
    }
    
    private void setCounts(String[] orders) {
        for(String o : orders) {
            combination(o, "", 0);
        }
    }
    
    private void combination(String order, String current, int depth) {
        if(depth == order.length()) {
            if(!current.isEmpty()) {
                add(current);
            }
            return;
        }
        combination(order, current + order.charAt(depth), depth + 1);
        combination(order, current, depth + 1);
    }
    
    private void add(String menu) {
        if(menu.length() > 1) {
            char[] c = menu.toCharArray();
            Arrays.sort(c);
            menu = String.valueOf(c);
        }
        count.put(menu, count.getOrDefault(menu, 0) + 1);
    }
}