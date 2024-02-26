package programmers;

public class IsDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "00234";
		boolean answer = false;
		char[] arr = s.toCharArray(); 
		for(char c : arr) { //어떤 명제가 참이면 그 명제의 대우도 참이다
			if(!(c >= '0' && c <='9') || !(arr.length ==4 || arr.length == 6)) {
				answer = false;
			}
		}
	}

}
