package baekjoon;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class 이상한곱셈2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		Long answer = 0L;
		

		String[] splitA = a.toString().split("");
		String[] splitB = b.toString().split("");
		
		for(int n = 0; n < splitA.length; n++) {
			for(int m = 0; m < splitB.length; m++) {
				answer += Integer.parseInt(splitA[n]) * Integer.parseInt(splitB[m]);
			}
		}
		
		System.out.println(answer);
		
	}
}
