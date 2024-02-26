package programmers;

public class 저주의_숫자_3 {

	public static void main(String[] args) {
		
		int n = 73; //130일 때...??
		
		for(int i =1; i<=n; i++) {
			if(i % 3 == 0 || i % 10 == 3 || i / 10 == 3 || i / 10 == 13) n++;
		}
		System.out.println(n);
	}
}
