package programers;

public class 다음_큰_숫자 {

	public static void main(String[] args) {
		//int로 하는 방법?
		//1001110 -> 1010011 -> 1010101(85)
		int n = 78;
		int answer = n;
		int binaryN = Integer.bitCount(n);

		while (true) {
			answer++;
			int binaryCount = Integer.bitCount(answer);
			if (binaryN == binaryCount)
				break;
		}
		
		System.out.println(answer);
	}
}
