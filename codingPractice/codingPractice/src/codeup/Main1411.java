package codeup;

import java.util.Scanner;

public class Main1411 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int[] card = new int[num];
		int index = 0;
		for (int i = 0; i < card.length; i++) {
			card[i] = i + 1;
		}

		for (int i = 0; i < num - 1; i++) {
			int having = sc.nextInt();
			card[having - 1] = 0;
		}

		for (int i = 0; i < card.length; i++) {
			if (card[i] != 0)
				index = i;
		}
		System.out.println(card[index]);
	}

}
