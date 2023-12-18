package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class 주사위 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		
		for(int x = 1; x <= a; x++) {
			for(int y = 1; y <= b; y++) {
				for(int z = 1; z <= c; z++) {
					count.put(x+y+z, count.getOrDefault(x+y+z, 0) + 1);
				}
			}
		}
		
		int max = count.entrySet().stream().max(Map.Entry.comparingByValue()).map(Entry::getKey).orElse(0);
		
		System.out.println(max);
	}
}
