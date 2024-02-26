package programmers;

public class LcmGcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =3;
		int m = 12;
		int[] answer = new int[2];
		answer[0] = gcd(Math.min(n, m), Math.max(n, m));
		answer[1] = lcm(Math.min(n, m), Math.max(n, m));
	}
	
	public static int gcd(int a, int b) {
		System.out.println("---------------------------");
		System.out.println(a);
		System.out.println(b);
		if(b == 0) return a;
		return gcd(b, a% b);
	}

	public static int lcm(int a, int b) {
		System.out.println("---------------------------");
		System.out.println(a);
		System.out.println(b);
		if(b == 0) return a;
		return (a*b) / gcd(b, a% b);
	}
}
