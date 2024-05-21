class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
		
		
		for(int i =0; i<quiz.length; i++) {
			String[] splitQuiz = quiz[i].split(" ");
			if(splitQuiz[1].equals("+")) {
				answer[i] = Integer.parseInt(splitQuiz[0]) + Integer.parseInt(splitQuiz[2]) 
				== Integer.parseInt(splitQuiz[4]) ? "O" : "X";
			} else if(splitQuiz[1].equals("-")) {
				answer[i] = Integer.parseInt(splitQuiz[0]) - Integer.parseInt(splitQuiz[2]) 
				== Integer.parseInt(splitQuiz[4]) ? "O" : "X";
			}
		}
        return answer;
    }
}