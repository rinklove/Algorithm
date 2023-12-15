package programers.kakao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 개인정보_수집_유효기간 {

	/**
	 * 모든 달의 일수가 28일이라는 점을 고려하지 못했다. 
	 * 테스트 케이스가 더 있었어도 틀렸을 듯
	 * @param args
	 */
	public static void main(String[] args) {
		
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
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
		
		for(int i : answer) {
			System.out.println(i);
		}
	}
}
