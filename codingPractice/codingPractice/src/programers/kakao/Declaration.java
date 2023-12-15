package programers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Declaration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		int k = 2;
		
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
	
		for(int i : answer) {
			System.out.print(i+" ");
		}
	}

}
