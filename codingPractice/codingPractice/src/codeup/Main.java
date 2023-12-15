package codeup;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		int[] num = new int[n];
		
		//n개의 숫자 넣기
		for(int i =0;i<num.length; i++) {
			int number = sc.nextInt();
			num[i] = number;
		}
		//m개의 질문
		int m = sc.nextInt();
		int[] question = new int[m];
		
		for(int i =0; i<question.length;i++) {
			question[i] = sc.nextInt();
		}
		int[] result = new int[m];
		
		for(int i=0; i<question.length;i++) {
			for(int j =0; j<num.length;j++) {				
				System.out.println("-------------------------------");
				System.out.println(num[j]);
				System.out.println(question[i]);			
				
				if(question[i] == num[j]) {
					result[i] = 1;	
				} else {
					
				}
			}
			System.out.println("-------------------------------");
			System.out.println(result[i]); //1
		}
		for(int i = 0; i<result.length;i++ ) {
			System.out.print(result[i]+ " ");
		}
	}
}
