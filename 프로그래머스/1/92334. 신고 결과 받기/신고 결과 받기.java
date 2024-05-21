import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> list = new ArrayList<>(Arrays.asList(id_list));
		Set<String> log = new HashSet<String>();
		Map<String, Integer> map = new HashMap<>();
		int[] answer = new int[list.size()];
		
		for(int i = 0; i< list.size();i++) {
			answer[i] = 0;
			map.put(list.get(i), 0);
		}
		//신고 처리(중복 불가 처리)
		for(int i = 0; i< report.length;i++) {
			String[] per =report[i].split(" ");
			if(!log.contains(report[i])) {
				map.put(per[1], map.getOrDefault(per[1], 0)+1);
				log.add(report[i]);
			}
		}
		System.out.println(map);
		
		for(String s : log) {
			String[] per = s.split(" ");
			if(map.get(per[1]) >= k) answer[list.indexOf(per[0])]++;
		}
        return answer;
    }
}