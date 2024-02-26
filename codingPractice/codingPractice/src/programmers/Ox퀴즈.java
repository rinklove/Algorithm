package programmers;

public class Ox퀴즈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//일단 split을 할까?
		String[] quiz = {"3 - 4 = -3", "5 + 6 = 11"};
		String[] answer = new String[quiz.length];
		
		
		for(int i =0; i<quiz.length; i++) {
			String[] splitQuiz = quiz[i].split(" ");
			if(splitQuiz[1].equals("+")) {
				answer[i] = Integer.parseInt(splitQuiz[0]) + Integer.parseInt(splitQuiz[2]) 
				== Integer.parseInt(splitQuiz[4]) ? "o" : "x";
			} else if(splitQuiz[1].equals("-")) {
				answer[i] = Integer.parseInt(splitQuiz[0]) - Integer.parseInt(splitQuiz[2]) 
				== Integer.parseInt(splitQuiz[4]) ? "o" : "x";
			}
		}
		for(String s : answer) {
			System.out.println(s);
		}
	}

}
