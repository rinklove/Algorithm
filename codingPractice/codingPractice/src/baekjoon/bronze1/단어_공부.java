package baekjoon.bronze1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;import java.util.Map.Entry;

/**
 * 
 */
public class 단어_공부 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine().toUpperCase();
		
		String[] split = input.split("");
		Map<String, Integer> count = new HashMap<String, Integer>();
		for(String s : split) {
			count.put(s, count.getOrDefault(s, 0)+1);
		}
		// 해당 맵에서 최대값과 비교하는 방법? 
		//Integer의 저장 가능 범위는 -128 ~ 127이니 조심하자
		int max = count.values().stream().max((a, b) -> a.compareTo(b)).orElse(0);
		
		 String[] list = count.entrySet().stream().filter(i -> i.getValue() == max).map(Entry::getKey).toArray(String[]::new);
		String answer = list.length > 1 ? "?" : list[0];
		System.out.println(answer);
	}
}
