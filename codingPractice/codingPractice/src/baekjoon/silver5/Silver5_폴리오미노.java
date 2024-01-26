package baekjoon.silver5;

import java.util.Scanner;

public class Silver5_폴리오미노 {

	public static void main(String[] args) {
		
		//XXXX -> AAAA
		//XX -> BB
		Scanner sc = new Scanner(System.in);
		String board = sc.nextLine();
		sc.close();
		
		while(board.contains("XXXX")) {
			board = board.replaceAll("XXXX", "AAAA");
		}
		
		while(board.contains("XX")) {
			board = board.replaceAll("XX", "BB");
		}
		
		if(board.contains("X")) {
			System.out.println(-1);
		} else { 
			System.out.println(board);
		}
	}
}
