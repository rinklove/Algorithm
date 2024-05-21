class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
		int card1Index = 0;
		int card2Index = 0;
        
		//동시에 탐색?
		for(int i = 0; i < goal.length; i++) {
			
			if(card1Index < cards1.length && goal[i].equals(cards1[card1Index])) {
				card1Index++;
				continue;
			}
			
			if(card2Index < cards2.length && goal[i].equals(cards2[card2Index])) {
				card2Index++;
				continue;
			}
			
			return "No";
		}
		
		
		return "Yes";

    }
}