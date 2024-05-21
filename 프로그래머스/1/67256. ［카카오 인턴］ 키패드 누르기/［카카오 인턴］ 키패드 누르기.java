class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left  = 10;	//*
		int right = 12;	//#
		int leftLength = 0;
		int rightLength = 0;
		
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] % 3 == 2 || numbers[i] == 0) {
				if(numbers[i] == 0) numbers[i] = 11;
				
				leftLength = (Math.abs(numbers[i] - left) / 3) + (Math.abs(numbers[i] - left) % 3);
				rightLength = (Math.abs(numbers[i] - right) / 3) + (Math.abs(numbers[i] - right) % 3);
				if(leftLength == rightLength) {
					String tmp = hand.substring(0, 1).toUpperCase();
					answer += tmp;
					switch(tmp) {
					case "L":
						left = numbers[i];
						break;
					case "R":
						right = numbers[i];
						break;
					}
				}
				else {
					if(leftLength > rightLength) {
						right = numbers[i];
						answer += "R";
					} else {
						left = numbers[i];
						answer += "L";
					}
				}
			} else if(numbers[i] % 3 == 1) {
				left = numbers[i];
				answer += "L";
			} else if(numbers[i] % 3 == 0) {
				right = numbers[i];
				answer += "R";
			}
		}
        return answer;
    }
}