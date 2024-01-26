package baekjoon.silver5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SortWord {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Set<String> set = new HashSet();
		
		int num = Integer.parseInt(sc.nextLine());
		for(int i =0; i<num;i++) {
			set.add(sc.nextLine());
		}
		List<String> list = new ArrayList<>(set);
		int index = 0;

		
		Collections.sort(list, new Comparator<String>() {
			//이 부분이 무슨 의미인지 파악해야할 듯
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() > s2.length()) return 1;
				else if(s1.length() < s2.length()) return -1;
				else return s1.compareTo(s2);
			}			
		});
		
		for(String s : list) {
			System.out.println(s);
		}
	}
}
