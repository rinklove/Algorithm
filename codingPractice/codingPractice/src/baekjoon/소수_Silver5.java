package baekjoon;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class 소수_Silver5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int N = sc.nextInt();
		
		int num = A % B; 
		
		for(int i = 0; i < N-1; i++) {
			num *= 10;
			num %= B;
		}
		num *= 10;
		System.out.println(num/B);
	}
}
