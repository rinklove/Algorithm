package baekjoon.silver5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Silver5_소트인사이드 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		String[] split = num.split("");
		
		String collect = Arrays.stream(split).sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.joining(""));
		System.out.println(collect);
	}
}
