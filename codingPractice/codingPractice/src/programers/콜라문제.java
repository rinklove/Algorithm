package programers;

public class 콜라문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 3;
		int b = 2;
		int n = 20; //빈병
		int answer = 0;
		
		while(n>=a) {
			answer += (n/a)*b;
			n  = (n/a)*b + (n%a);
		}
		System.out.println(answer);
	}

	
}
