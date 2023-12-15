package baekjoon;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.math.BigInteger;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//문자를 정렬했을 때 오는 1/2번째 문자를 포함해서 잘라야함.
		Scanner sc = new Scanner(System.in);
		int startYear = sc.nextInt();
		int startMonth = sc.nextInt();
		int startDay = sc.nextInt();
		int endYear = sc.nextInt();
		int endMonth = sc.nextInt();
		int endDay = sc.nextInt();
		LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);
		
		endDate = endDate.minusYears(startYear).minusMonths(startMonth).minusDays(startDay);
		System.out.println(endDate.toString());
		System.out.println(endDate.getDayOfMonth());
		System.out.println(endDate.getDayOfYear());
//		endDate.
	}
}
