package programers;

import java.util.Arrays;
import java.util.stream.Collectors;


public class 카드_뭉치 {

	public static void main(String[] args) {
		
		//섞여 있어도 순서는 지켜져야함.
		String[] cards1 = {"i", "water", "drink"};
		String[] cards2 = {"want", "to"};
		String[] goal = {"i", "want", "to", "drink", "water"};
		String answer = "";
		int card1Index = 0;
		int card2Index = 0;
		//동시에 탐색?
		for(int i = 0; i < goal.length; i++) {
			
			if(card1Index < cards1.length && goal[i].equals(card1Index)) {
				card1Index++;
				continue;
			}
			
			if(card2Index < cards2.length && goal[i].equals(card2Index)) {
				card2Index++;
				continue;
			}
			
//			return "No";
		}
		
		
//		return "Yes";
	}
	
}
