package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 약수 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
	
		int[] arr = new int[count];
		
		for(int i = 0; i < count; i ++) {
			arr[i] = sc.nextInt();
		}
		
		if(count == 1) {
			System.out.println(arr[0]*arr[0]);
		} else {
			Arrays.sort(arr);
			System.out.println(arr[0]*arr[count-1]);			
		}
	}
}
