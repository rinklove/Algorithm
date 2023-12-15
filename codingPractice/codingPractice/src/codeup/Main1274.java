package codeup;

import java.util.Scanner;

public class Main1274 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean isPrime = true;
		
		for(int div = 2; div <num;div++) {
			if(num % div == 0) isPrime = false;
		}
		
		String str = isPrime? "prime" : "not prime";
		System.out.println(str);
	}

}
