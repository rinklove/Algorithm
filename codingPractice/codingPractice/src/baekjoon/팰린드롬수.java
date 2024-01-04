package baekjoon;

import java.util.Scanner;

public class 팰린드롬수 {

	//StringBuilder 자체로 비교하면, 주소값으로 비교함
	//toString()으로 StringBuilder안의 값으로 비교해야함
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true) {
			String num = String.valueOf(s.nextInt());
			if(num.equals("0")) break;
			StringBuilder sb = new StringBuilder(num);

			String origin = sb.toString();
			String reverse = sb.reverse().toString();
			
			String isSame = reverse.equals(origin) ? "yes" : "no";
			System.out.println(isSame);			
		}
		s.close();
	}
}
