import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

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

        return answer;
    }
}