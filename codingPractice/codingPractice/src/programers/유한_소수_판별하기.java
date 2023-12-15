package programers;

public class 유한_소수_판별하기 {
	
	public static void main(String[] args) {
		int a = 7;
		int b = 20;
		int answer = 0;
		int number = gcd(Math.min(a,b), Math.max(a, b));
		a /= number;
		b /= number;
		
		while(b != 1) {
			if(b % 2 == 0) b/= 2;
			else if(b % 5 == 0) b/= 5;
			else break;
		}
		answer = b == 1? 1 : 2;
	} 
	
	public static int gcd(int a, int b) {
		System.out.println("---------------------------");
		System.out.println(a);
		System.out.println(b);
		if(b == 0) return a;
		return gcd(b, a% b);
	}
}
