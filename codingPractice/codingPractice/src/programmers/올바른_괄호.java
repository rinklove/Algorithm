package programmers;

public class 올바른_괄호 {

	public static void main(String[] args) {
		
		String s = "()()";
		int tmp = 0;
		for(int i = 0; i < s.length(); i++) {
			String per = s.substring(i, i+1);
			
			if(per.equals("(")) tmp++;
			else tmp--;
			
//			if(tmp < 0) //return false;
		}
		
		boolean answer = tmp == 0? true : false;
		
	}
}
