import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] todaySplit = today.split("[.]");
		LocalDate todayDate = LocalDate.of(Integer.parseInt(todaySplit[0]), Integer.parseInt(todaySplit[1]),Integer.parseInt(todaySplit[2]));
		Map<String, Integer> termMap = new HashMap<>();
		
		for(String s : terms) {
			String[] split2 = s.split(" ");
			termMap.put(split2[0], Integer.parseInt(split2[1]));
		}
		List<Integer> list = new ArrayList<>();

		for(int i = 0; i < privacies.length; i++) {
			String[] split3 = privacies[i].split(" ");
			String[] eachDay = split3[0].split("[.]");
			
			LocalDate eachDate = LocalDate.of(Integer.parseInt(eachDay[0]), Integer.parseInt(eachDay[1]), Integer.parseInt(eachDay[2]));
			 eachDate = eachDate.plusMonths(termMap.get(split3[1]));
			
			if(todayDate.compareTo(eachDate) >= 0) {
				list.add(i+1);
			}
		}
		
		int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}