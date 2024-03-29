package baekjoon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int answer = 0;
		
		String[] splitA = String.valueOf(a).split("");
		String[] splitB = String.valueOf(b).split("");
		
		for(int n = 0; n < splitA.length; n++) {
			for(int m = 0; m < splitB.length; m++) {
				answer += Integer.parseInt(splitA[n]) * Integer.parseInt(splitB[m]);
			}
		}
		
		System.out.println(answer);
	}
}
