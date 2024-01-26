package baekjoon.silver5;

import java.util.Scanner;

public class Silver5_방번호 {

	public static void main(String[] args) {
		
		//0~9 // 0~5 6, 6 7 8 // 0~5 7 8 9 9
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int count = 0;
		if(str.contains("9")) {
			str = str.replaceAll("9", "6");
		}
		
		while (!str.equals("")) {
			str = str.replaceFirst("0", "");
			str = str.replaceFirst("1", "");
			str = str.replaceFirst("2", "");
			str = str.replaceFirst("3", "");
			str = str.replaceFirst("4", "");
			str = str.replaceFirst("5", "");
			str = str.replaceFirst("6", "");
			str = str.replaceFirst("6", "");
			str = str.replaceFirst("7", "");
			str = str.replaceFirst("8", "");
			count++;
		}
		
		System.out.println(count);
		
	}
}
