package baekjoon.silver5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Silver5_뒤집기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		String str = sc.next();
		map.put("0", 0);
		map.put("1", 0);
		String previous = str.substring(0, 1);
		map.put(previous, map.get(previous)+1);
		
		for(int i = 1; i <str.length(); i++) {
			String current = str.substring(i, i+1);
			
			if(!current.equals(previous)) {
				map.put(current, map.get(current)+1);
			}
			
			previous = current;
		}
		
		int min = map.values().stream().mapToInt(i-> i).min().getAsInt();
		System.out.println(min);
	}
}
