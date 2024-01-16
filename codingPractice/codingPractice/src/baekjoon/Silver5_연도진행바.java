package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Silver5_연도진행바 {
	
	public static void main(String[] args) {
		//1. 해당 연도의 전체 일수를 구해야함.
		//2. 입력값으로 받은 String을 LocalDatetime으로 반환
		//3. (해당 연도+1)의 1월 1일 0시 0분
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().replaceAll("[,:]", "");
//		System.out.println(str); //May 10 1981 0031 월 일 시간 HHMI
		String[] split = str.split(" ");
		Map<String, Integer> month = getMonth();
		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int dayOfYear = 365;
		int year = Integer.parseInt(split[2]);
		if( year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ) {
			dayOfYear++;
			days[1]++;
		}
		dayOfYear *= (24 * 60);
		
		int inputDay = 0;
		for(int m = 1; m < month.get(split[0]); m++) {
			inputDay += days[m-1];
		}
		inputDay += Integer.parseInt(split[1])-1;
		inputDay = inputDay * 24 * 60 + Integer.parseInt(split[3].substring(0, 2)) *60 +  Integer.parseInt(split[3].substring(2));
		System.out.println((double)inputDay / (double) dayOfYear * 100);
	}

	private static Map<String, Integer> getMonth() {
		Map<String, Integer> month = new HashMap<String, Integer>();
		month.put("January", 1);
		month.put("February", 2);
		month.put("March", 3);
		month.put("April", 4);
		month.put("May", 5);
		month.put("June", 6);
		month.put("July", 7);
		month.put("August", 8);
		month.put("September", 9);
		month.put("October", 10);
		month.put("November", 11);
		month.put("December", 12);
		return month;
	}
}
