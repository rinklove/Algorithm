package programers.kakao;

import java.util.Stack;

public class 크레인_인형_뽑기 {

	public static void main(String[] args) {
		//어피치 - 무지 -어피치
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		for(int line = 0; line< moves.length; line++) {
			for(int depth  =0; depth<board.length; depth++) {
				if(board[depth][moves[line]-1] == 0) continue;
				else  {
					System.out.println("stack.peek(): "+stack.peek());
					System.out.println("board[depth][moves[line]-1]: "+board[depth][moves[line]-1]);
					if(stack.peek() == board[depth][moves[line]-1]) {
						stack.pop();
						answer += 2;
					}else {
						stack.push(board[depth][moves[line]-1]);						
					}
					board[depth][moves[line]-1] = 0;
					System.out.println(stack);
					System.out.println(answer);					
					System.out.println("-----------------------------------------------");
					break;
				}
			}
		}
	}
}
