package programmers;


import java.util.Stack;

public class 짝지어_제거하기 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//스택?
		String s = "baabaa";
		int answer = 0;
		String[] arr = s.split("");
		Stack<String> stack = new Stack<>();
		
		for(int index = 0; index < arr.length; index++) {
			if(stack.isEmpty()) {
				stack.push(arr[index]);
			} else {
				if(arr[index].equals(stack.peek())) {
					stack.pop();
				} else stack.push(arr[index]);
			}
		}
		answer = stack.isEmpty() ? 1 : 0;
		
		System.out.println(answer);
		
	}
}
