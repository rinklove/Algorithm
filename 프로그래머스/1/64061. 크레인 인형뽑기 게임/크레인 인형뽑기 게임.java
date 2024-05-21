import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
		stack.push(0);
        
        
        for(int line = 0; line< moves.length; line++) {
			for(int depth  =0; depth<board.length; depth++) {
				if(board[depth][moves[line]-1] == 0) continue;
				else  {
					if(stack.peek() == board[depth][moves[line]-1]) {
						stack.pop();
						answer += 2;
					}else {
						stack.push(board[depth][moves[line]-1]);						
					}
					board[depth][moves[line]-1] = 0;
					break;
				}
			}
		}
        return answer;
    }
}