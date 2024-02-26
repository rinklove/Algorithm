package programmers;

public class 공던지기 {

	public static void main(String[] args) {
		
		int[] numbers = {1,2,3};
		int k = 3;
		System.out.println(numbers[(0+2*(k-1)) % numbers.length]);
	}
}
