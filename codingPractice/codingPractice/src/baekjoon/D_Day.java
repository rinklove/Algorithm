package baekjoon;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.Scanner;

public class D_Day {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String today = sc.nextLine();
		String end = sc.nextLine();
		sc.close();
		
		
//		진행중
//		----------------------------------------------
//		String[] todayArr = today.split(" ");
//		String[] endArr = end.split(" ");
//		LocalDate todayDate = LocalDate.of(Integer.parseInt(todayArr[0]), Integer.parseInt(todayArr[1]), Integer.parseInt(todayArr[2]));
//		LocalDate endDate = LocalDate.of(Integer.parseInt(endArr[0]), Integer.parseInt(endArr[1]), Integer.parseInt(endArr[2]));
//		
//		int compareTo = endDate.compareTo(todayDate);
//		Period until = endDate.until(todayDate);
//		System.out.println(until.getYears());
//		System.out.println(until.getMonths());
//		System.out.println(until.getDays());
//		until.m
	}
}
