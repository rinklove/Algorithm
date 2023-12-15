package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import card.Card;
import card.CardGameHelper;
import card.OneCardManager;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("원카드");
		CardGameHelper helper = new CardGameHelper();
		helper.playCardGame();
		
		
	}
}
