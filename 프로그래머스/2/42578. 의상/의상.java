import java.util.Map;
import java.util.HashMap;

class Solution {
    private final Map<String, Integer> map = new HashMap<>();

    public int solution(String[][] clothes) {
        initMap(clothes);
        return calculateTotalCases(map.values().toArray(new Integer[0]));
    }

    private void initMap(String[][] clothes) {
        for (String[] c : clothes) {
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
    }

    private int calculateTotalCases(Integer[] counts) {
        int totalCases = 1;
        for (int count : counts) {
            System.out.println(count);
            // 각 종류의 옷을 선택하지 않는 경우를 고려하여 +1을 합니다.
            totalCases *= (count + 1);
        }
        // 모든 종류의 옷을 선택하지 않는 경우를 제외합니다.
        return totalCases - 1;
    }
}
